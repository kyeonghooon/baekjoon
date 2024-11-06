package org.example.solv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final int TOTAL_EMPLOYEES = 10;
    private static final int STORE_ID = 1;
    private static final int WAGE = 9860;
    private static final int START_YEAR = 2024;
    private static final int START_MONTH = 10;

    private static final List<String> scheduleInserts = new ArrayList<>();
    private static final List<String> attendanceInserts = new ArrayList<>();
    private static int scheduleIdCounter = 1;
    private static int attendanceIdCounter = 1;

    private static final Random random = new Random();

    // 직원별 근무 일정을 추적하기 위한 Map (empId -> List of LocalDate)
    private static final Map<Integer, List<LocalDate>> employeeSchedules = new HashMap<>();

    // Schedule ID을 (empId_date)로 추적하기 위한 Map
    private static final Map<String, Integer> scheduleIdMap = new HashMap<>();

    // Define batch size
    private static final int BATCH_SIZE = 50; // 배치 크기를 50으로 설정

    // 파일 경로 설정 (절대 경로로 변경 권장)
    private static final String SCHEDULE_FILE = "schedule_inserts.sql";
    private static final String ATTENDANCE_FILE = "attendance_inserts.sql";

    public static void main(String[] args) {
        // 모든 근무일 (월요일~금요일) 가져오기
        List<LocalDate> workdays = getWorkdays(START_YEAR, START_MONTH);
        System.out.println("근무일 수: " + workdays.size());

        // 직원별로 근무일 목록 초기화
        for (int empId = 1; empId <= TOTAL_EMPLOYEES; empId++) {
            employeeSchedules.put(empId, new ArrayList<>());
        }

        // 파일 작성을 위한 BufferedWriter 초기화
        try (BufferedWriter scheduleWriter = new BufferedWriter(new FileWriter(SCHEDULE_FILE));
             BufferedWriter attendanceWriter = new BufferedWriter(new FileWriter(ATTENDANCE_FILE))) {

            // 각 직원의 각 근무일에 대해 Schedule 및 Attendance 생성
            for (int empId = 1; empId <= TOTAL_EMPLOYEES; empId++) {
                for (LocalDate date : workdays) {
                    // 이미 해당 직원이 해당 날짜에 근무 중인지 확인 (중복 방지)
                    if (employeeSchedules.get(empId).contains(date)) {
                        continue;
                    }

                    // 스케줄 생성
                    LocalTime scheduleStart = getRandomTime();
                    // 근무 시간은 4~10시간 사이로 무작위 설정
                    int workDurationHours = 4 + random.nextInt(7); // 4~10시간
                    int workDurationMinutes = random.nextBoolean() ? 0 : 30; // 0분 또는 30분 추가
                    LocalTime scheduleEnd = scheduleStart.plusHours(workDurationHours).plusMinutes(workDurationMinutes);

                    // 야간 근무 처리
                    boolean overnight = false;
                    if (scheduleEnd.isBefore(scheduleStart) || scheduleEnd.equals(scheduleStart)) {
                        overnight = true;
                        scheduleEnd = scheduleEnd.plusHours(24);
                    }

                    LocalDateTime scheduleStartDateTime = LocalDateTime.of(date, scheduleStart);
                    LocalDateTime scheduleEndDateTime = overnight
                            ? LocalDateTime.of(date.plusDays(1), scheduleEnd.minusHours(24))
                            : LocalDateTime.of(date, scheduleEnd);

                    String scheduleStatus = "COMPLETED";

                    String scheduleInsert = String.format(
                            "(%d, %d, %d, '%s', '%s', '%s')",
                            scheduleIdCounter,
                            STORE_ID,
                            empId,
                            Timestamp.valueOf(scheduleStartDateTime).toString(),
                            Timestamp.valueOf(scheduleEndDateTime).toString(),
                            scheduleStatus
                    );
                    scheduleInserts.add(scheduleInsert);

                    // (empId, date) 키로 scheduleId 저장
                    String key = empId + "_" + date.toString();
                    scheduleIdMap.put(key, scheduleIdCounter);

                    // 직원의 근무 일정에 추가
                    employeeSchedules.get(empId).add(date);

                    // Attendance 상태 결정
                    String status = getStatus();

                    // Attendance 생성
                    String attendanceInsert = generateAttendanceInsert(empId, scheduleIdCounter, scheduleStartDateTime, scheduleEndDateTime, status);
                    if (attendanceInsert != null) { // NULL 체크
                        attendanceInserts.add(attendanceInsert);
                        attendanceIdCounter++;
                    }

                    scheduleIdCounter++;

                    // Schedule INSERT 배치 처리
                    if (scheduleInserts.size() >= BATCH_SIZE) {
                        printScheduleBatch(scheduleWriter);
                    }

                    // Attendance INSERT 배치 처리
                    if (attendanceInserts.size() >= BATCH_SIZE) {
                        printAttendanceBatch(attendanceWriter);
                    }
                }
            }

            // 남은 배치 처리
            if (!scheduleInserts.isEmpty()) {
                printScheduleBatch(scheduleWriter);
            }

            if (!attendanceInserts.isEmpty()) {
                printAttendanceBatch(attendanceWriter);
            }

            System.out.println("INSERT 문 생성이 완료되었습니다. 파일을 확인해주세요.");

        } catch (IOException e) {
            System.err.println("INSERT 문 생성 중 오류가 발생하였습니다. 오류 내용을 확인해주세요.");
            e.printStackTrace();
        }
    }

    // 모든 근무일 (월~금) 가져오기
    private static List<LocalDate> getWorkdays(int year, int month) {
        List<LocalDate> workdays = new ArrayList<>();
        YearMonth yearMonth = YearMonth.of(year, month);
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = yearMonth.atDay(day);
            DayOfWeek dow = date.getDayOfWeek();
            if (dow != DayOfWeek.SATURDAY && dow != DayOfWeek.SUNDAY) {
                workdays.add(date);
            }
        }
        return workdays;
    }

    // 랜덤 시간 가져오기 (정각 또는 반각)
    private static LocalTime getRandomTime() {
        int hour = random.nextInt(24);
        int minute = random.nextBoolean() ? 0 : 30; // 정각 또는 반각
        return LocalTime.of(hour, minute);
    }

    // Break Time 계산 (4시간당 최소 30분)
    private static int calculateBreakTime(int workMinutes) {
        int breakTime = (workMinutes / 240) * 30;
        return breakTime > 0 ? breakTime : 0;
    }

    // Attendance 상태 결정 (분포에 따라)
    private static String getStatus() {
        double rand = random.nextDouble() * 100;
        if (rand < 70) return "ATTENDED";
        rand -= 70;
        if (rand < 5) return "LEFT_EARLY";
        rand -= 5;
        if (rand < 5) return "LATE";
        rand -= 5;
        if (rand < 3) return "LATE_AND_LEFT_EARLY";
        // 나머지 7%는 결근으로 처리
        // 결근 유형 중 하나를 랜덤으로 선택
        int absentType = random.nextInt(3);
        switch (absentType) {
            case 0:
                return "SICK_ABSENT";
            case 1:
                return "UNAUTHORIZED_ABSENT";
            case 2:
                return "PERSONAL_ABSENT";
            default:
                return "UNAUTHORIZED_ABSENT"; // 기본값
        }
    }

    // Attendance INSERT 생성
    private static String generateAttendanceInsert(int empId, int scheduleId, LocalDateTime scheduleStart, LocalDateTime scheduleEnd, String status) {
        if (status.equals("SICK_ABSENT") || status.equals("UNAUTHORIZED_ABSENT") || status.equals("PERSONAL_ABSENT")) {
            // 결근 상태 처리: start_time과 end_time을 NULL로 설정
            return String.format(
                    "(%d, %d, %d, NULL, NULL, %d, '%s', NULL, NULL, %d, NULL, NULL)",
                    attendanceIdCounter,
                    STORE_ID,
                    empId,
                    scheduleId,
                    status,
                    WAGE
            );
        } else {
            LocalDateTime attendanceStart = scheduleStart;
            LocalDateTime attendanceEnd = scheduleEnd;
            int missedTime = 0;
            int overTime = 0;

            // 상태에 따른 출퇴근 시간 조정
            switch (status) {
                case "ATTENDED":
                    // 30% 확률로 퇴근 시간 연장
                    if (random.nextDouble() < 0.3) {
                        int extraMinutes = 30 + random.nextInt(31); // 30~60분 추가
                        attendanceEnd = attendanceEnd.plusMinutes(extraMinutes);
                        overTime += extraMinutes;
                    }
                    // 30% 확률로 조기 출근
                    if (random.nextDouble() < 0.3) {
                        int earlyArrival = 5 + random.nextInt(16); // 5~20분 일찍 출근
                        attendanceStart = attendanceStart.minusMinutes(earlyArrival);
                        overTime += earlyArrival;
                    }
                    break;
                case "LATE":
                    int lateMinutes = 5 + random.nextInt(26); // 5~30분 지각
                    attendanceStart = attendanceStart.plusMinutes(lateMinutes);
                    missedTime += lateMinutes;
                    break;
                case "LEFT_EARLY":
                    int earlyMinutes = 5 + random.nextInt(26); // 5~30분 조퇴
                    attendanceEnd = attendanceEnd.minusMinutes(earlyMinutes);
                    missedTime += earlyMinutes;
                    break;
                case "LATE_AND_LEFT_EARLY":
                    int totalMissed = 5 + random.nextInt(26); // 5~30분 지각 및 조퇴
                    int halfMissed = totalMissed / 2;
                    attendanceStart = attendanceStart.plusMinutes(halfMissed);
                    attendanceEnd = attendanceEnd.minusMinutes(totalMissed - halfMissed);
                    missedTime += totalMissed;
                    break;
                default:
                    break;
            }

            // 실제 근무 시간 계산
            int totalWorkedMinutes = (int) Duration.between(attendanceStart, attendanceEnd).toMinutes();

            // Break Time 계산
            int breakTime = calculateBreakTime(totalWorkedMinutes);

            // Work Time 계산
            int workTime = totalWorkedMinutes - breakTime;

            // Missed Time과 Over Time 계산
            if (attendanceStart.isAfter(scheduleStart)) {
                missedTime += (int) Duration.between(scheduleStart, attendanceStart).toMinutes();
            }

            if (attendanceEnd.isAfter(scheduleEnd)) {
                overTime += (int) Duration.between(scheduleEnd, attendanceEnd).toMinutes();
            }

            // Work Time과 Break Time의 합이 실제 근무 시간과 일치하도록 조정
            int totalTime = workTime + breakTime;
            int actualTotal = (int) Duration.between(attendanceStart, attendanceEnd).toMinutes();
            if (totalTime != actualTotal) {
                workTime = actualTotal - breakTime;
            }

            // Work Time 음수 방지
            if (workTime < 0) workTime = 0;

            // Timestamp 포맷팅
            String startTimestamp = Timestamp.valueOf(attendanceStart).toString();
            String endTimestamp = Timestamp.valueOf(attendanceEnd).toString();

            return String.format(
                    "(%d, %d, %d, '%s', '%s', %d, '%s', %d, %d, %d, %d, %d)",
                    attendanceIdCounter,
                    STORE_ID,
                    empId,
                    startTimestamp,
                    endTimestamp,
                    scheduleId,
                    status,
                    workTime,
                    breakTime,
                    WAGE,
                    missedTime > 0 ? missedTime : 0,
                    overTime > 0 ? overTime : 0
            );
        }
    }

    // Schedule INSERT 배치 출력
    private static void printScheduleBatch(BufferedWriter scheduleWriter) throws IOException {
        if (scheduleInserts.isEmpty()) return;
        String scheduleInsertQuery = "INSERT INTO hr_schedule_tb (id, store_id, emp_id, start_time, end_time, status) VALUES\n" +
                String.join(",\n", scheduleInserts) + ";\n";
        scheduleWriter.write("-- Schedule INSERT Statement\n");
        scheduleWriter.write(scheduleInsertQuery);
        scheduleWriter.flush();
        System.out.println("Schedule INSERT 배치 완료: " + scheduleInserts.size() + "개");
        scheduleInserts.clear();
    }

    // Attendance INSERT 배치 출력
    private static void printAttendanceBatch(BufferedWriter attendanceWriter) throws IOException {
        if (attendanceInserts.isEmpty()) return;
        String attendanceInsertQuery = "INSERT INTO hr_attendance_tb (id, store_id, emp_id, start_time, end_time, schedule_id, status, work_time, break_time, wage, missed_time, overed_time) VALUES\n" +
                String.join(",\n", attendanceInserts) + ";\n";
        attendanceWriter.write("-- Attendance INSERT Statement\n");
        attendanceWriter.write(attendanceInsertQuery);
        attendanceWriter.flush();
        System.out.println("Attendance INSERT 배치 완료: " + attendanceInserts.size() + "개");
        attendanceInserts.clear();
    }
}
