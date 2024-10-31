package org.example.solv;

import java.sql.Timestamp;
import java.time.*;
import java.util.*;

public class Main {

	private static final int TOTAL_EMPLOYEES = 10;
	private static final int STORE_ID = 1;
	private static final int WAGE = 9860;
	private static final int START_YEAR = 2024;
	private static final int START_MONTH = 9; // September

	private static final List<AttendanceStatusCount> statusCounts = new ArrayList<>();
	private static final List<String> scheduleInserts = new ArrayList<>();
	private static final List<String> attendanceInserts = new ArrayList<>();
	private static int scheduleIdCounter = 1;
	private static int attendanceIdCounter = 1;

	private static final Random random = new Random();

	public static void main(String[] args) {
		initializeStatusCounts();

		// Get all workdays (Monday to Friday) in September 2024
		List<LocalDate> workdays = getWorkdays(START_YEAR, START_MONTH);

		// Generate Schedule and Attendance for each employee on each workday
		for (int empId = 1; empId <= TOTAL_EMPLOYEES; empId++) {
			for (LocalDate date : workdays) {
				// Create Schedule
				LocalTime scheduleStart = getRandomTime();
				// Assume standard shift duration is 8 hours
				LocalTime scheduleEnd = scheduleStart.plusHours(8);

				// Handle overnight shifts
				boolean overnight = false;
				if (scheduleEnd.isBefore(scheduleStart) || scheduleEnd.equals(scheduleStart)) {
					overnight = true;
					scheduleEnd = scheduleEnd.plusHours(24);
				}

				LocalDateTime scheduleStartDateTime = LocalDateTime.of(date, scheduleStart);
				LocalDateTime scheduleEndDateTime = overnight
						? LocalDateTime.of(date.plusDays(1), scheduleEnd.minusHours(24))
						: LocalDateTime.of(date, scheduleEnd);

				// Since all schedules are in the past (2024-09-01 to 2024-09-30 vs current date 2024-10-30), set status to COMPLETED
				String scheduleStatus = "COMPLETED";

				String scheduleInsert = String.format(
						"INSERT INTO hr_schedule_tb (id, store_id, emp_id, start_time, end_time, status) VALUES (%d, %d, %d, '%s', '%s', '%s');",
						scheduleIdCounter,
						STORE_ID,
						empId,
						Timestamp.valueOf(scheduleStartDateTime).toString(),
						Timestamp.valueOf(scheduleEndDateTime).toString(),
						scheduleStatus
				);
				scheduleInserts.add(scheduleInsert);

				// Determine Attendance Status based on distribution
				String status = getStatus();

				// Create Attendance
				String attendanceInsert = generateAttendanceInsert(empId, scheduleIdCounter, scheduleStartDateTime, scheduleEndDateTime, status);
				attendanceInserts.add(attendanceInsert);

				scheduleIdCounter++;
				attendanceIdCounter++;
			}
		}

		// Generate UNPLANNED_WORK Attendance records (10% of total scheduled Attendances)
		int totalScheduledAttendances = TOTAL_EMPLOYEES * workdays.size();
		int unplannedWorkCount = (int) Math.round(totalScheduledAttendances * 0.10);

		for (int i = 0; i < unplannedWorkCount; i++) {
			int empId = 1 + random.nextInt(TOTAL_EMPLOYEES);
			LocalDate date = getRandomWeekendDate(START_YEAR, START_MONTH);
			if (date == null) continue; // If no weekends available

			LocalTime workStart = getRandomTime();
			// Assume unplanned work duration is between 4 to 10 hours
			int workDurationHours = 4 + random.nextInt(7); // 4 to 10 hours
			LocalTime workEnd = workStart.plusHours(workDurationHours);

			// Handle overnight shifts
			boolean overnight = false;
			if (workEnd.isBefore(workStart) || workEnd.equals(workStart)) {
				overnight = true;
				workEnd = workEnd.plusHours(24);
			}

			LocalDateTime workStartDateTime = LocalDateTime.of(date, workStart);
			LocalDateTime workEndDateTime = overnight
					? LocalDateTime.of(date.plusDays(1), workEnd.minusHours(24))
					: LocalDateTime.of(date, workEnd);

			// Calculate work_time and break_time
			int totalWorkedMinutes = (int) Duration.between(workStartDateTime, workEndDateTime).toMinutes();
			int breakTimeUnplanned = calculateBreakTime(totalWorkedMinutes);
			int workTimeUnplanned = totalWorkedMinutes - breakTimeUnplanned;

			String attendanceInsert = String.format(
					"INSERT INTO hr_attendance_tb (id, store_id, emp_id, start_time, end_time, schedule_id, status, work_time, break_time, wage, missed_time, over_time) VALUES (%d, %d, %d, '%s', '%s', NULL, '%s', %d, %d, %d, NULL, NULL);",
					attendanceIdCounter,
					STORE_ID,
					empId,
					Timestamp.valueOf(workStartDateTime).toString(),
					Timestamp.valueOf(workEndDateTime).toString(),
					"UNPLANNED_WORK",
					workTimeUnplanned,
					breakTimeUnplanned,
					WAGE
			);
			attendanceInserts.add(attendanceInsert);
			attendanceIdCounter++;
		}

		// Generate Absent Attendances based on distribution (7% of total scheduled Attendances)
		int totalAbsent = (int) Math.round(totalScheduledAttendances * 0.07); // 2% + 1% +4% =7%

		for (int i = 0; i < totalAbsent; i++) {
			int empId = 1 + random.nextInt(TOTAL_EMPLOYEES);
			LocalDate date = getRandomWorkday(START_YEAR, START_MONTH, workdays, empId);
			if (date == null) continue;

			// Find corresponding Schedule and Attendance
			int scheduleId = findScheduleId(empId, date);
			if (scheduleId == -1) continue;

			// Randomly choose absent status
			String absentStatus = getAbsentStatus();

			// Generate Absent Attendance INSERT
			String attendanceInsert = String.format(
					"INSERT INTO hr_attendance_tb (id, store_id, emp_id, start_time, end_time, schedule_id, status, work_time, break_time, wage, missed_time, over_time) VALUES (%d, %d, %d, NULL, NULL, %d, '%s', NULL, NULL, %d, NULL, NULL);",
					attendanceIdCounter,
					STORE_ID,
					empId,
					scheduleId,
					absentStatus,
					WAGE
			);
			attendanceInserts.add(attendanceInsert);
			attendanceIdCounter++;
		}

		// Shuffle Attendance Inserts to mix scheduled, unplanned, and absent Attendances
		Collections.shuffle(attendanceInserts, random);

		// 출력: Schedule INSERTs 먼저, 그 다음 Attendance INSERTs
		System.out.println("-- Schedule INSERT Statements");
		for (String insert : scheduleInserts) {
			System.out.println(insert);
		}

		System.out.println("\n-- Attendance INSERT Statements");
		for (String insert : attendanceInserts) {
			System.out.println(insert);
		}
	}

	// Initialize status counts based on the specified distribution
	private static void initializeStatusCounts() {
		// For scheduled Attendances (93%)
		statusCounts.add(new AttendanceStatusCount("ATTENDED", 70)); // 70%
		statusCounts.add(new AttendanceStatusCount("LEFT_EARLY", 5)); // 5%
		statusCounts.add(new AttendanceStatusCount("LATE", 5)); // 5%
		statusCounts.add(new AttendanceStatusCount("LATE_AND_LEFT_EARLY", 3)); // 3%
		statusCounts.add(new AttendanceStatusCount("UNAUTHORIZED_ABSENT", 2)); // 2%
		statusCounts.add(new AttendanceStatusCount("SICK_ABSENT", 1)); // 1%
		statusCounts.add(new AttendanceStatusCount("PERSONAL_ABSENT", 4)); // 4%
		// 'UNPLANNED_WORK' is handled separately (10%)
	}

	// Get a list of all workdays (Monday to Friday) in the specified month and year
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

	// Get a random weekend date (Saturday or Sunday) in the specified month and year
	private static LocalDate getRandomWeekendDate(int year, int month) {
		List<LocalDate> weekends = new ArrayList<>();
		YearMonth yearMonth = YearMonth.of(year, month);
		for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
			LocalDate date = yearMonth.atDay(day);
			DayOfWeek dow = date.getDayOfWeek();
			if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) {
				weekends.add(date);
			}
		}
		if (weekends.isEmpty()) return null;
		return weekends.get(random.nextInt(weekends.size()));
	}

	// Get a random workday for a specific employee to assign absence
	private static LocalDate getRandomWorkday(int year, int month, List<LocalDate> workdays, int empId) {
		List<LocalDate> availableWorkdays = new ArrayList<>(workdays);
		Collections.shuffle(availableWorkdays, random);
		for (LocalDate date : availableWorkdays) {
			if (!isAlreadyAbsent(empId, date)) {
				return date;
			}
		}
		return null;
	}

	// Check if the employee is already marked absent on the given date
	private static boolean isAlreadyAbsent(int empId, LocalDate date) {
		// Implement logic if needed to prevent multiple absences on the same day
		// For simplicity, assuming it's handled elsewhere
		return false;
	}

	// Find the Schedule ID for a given employee and date
	private static int findScheduleId(int empId, LocalDate date) {
		for (String insert : scheduleInserts) {
			if (insert.contains(", " + STORE_ID + ", " + empId + ", '" + date.toString())) {
				// Extract the Schedule ID
				int idStart = insert.indexOf("(") + 1;
				int idEnd = insert.indexOf(",", idStart);
				String idStr = insert.substring(idStart, idEnd).trim();
				try {
					return Integer.parseInt(idStr);
				} catch (NumberFormatException e) {
					return -1;
				}
			}
		}
		return -1;
	}

	// Generate Attendance INSERT statement based on status
	private static String generateAttendanceInsert(int empId, int scheduleId, LocalDateTime scheduleStart, LocalDateTime scheduleEnd, String status) {
		LocalDateTime attendanceStart = scheduleStart;
		LocalDateTime attendanceEnd = scheduleEnd;
		int workTime = 480; // 8 hours in minutes
		int breakTime = calculateBreakTime(workTime);
		int missedTime = 0;
		int overTime = 0;

		// Adjust times based on status
		switch (status) {
			case "ATTENDED":
				// 20% chance to leave late
				if (random.nextDouble() < 0.2) { // 20% chance to leave late
					int extraMinutes = 30 + random.nextInt(31); // 30 to 60 minutes
					attendanceEnd = attendanceEnd.plusMinutes(extraMinutes);
					overTime += extraMinutes;
				}
				break;
			case "LATE":
				int lateMinutes = 5 + random.nextInt(26); // 5 to 30 minutes
				attendanceStart = attendanceStart.plusMinutes(lateMinutes);
				missedTime += lateMinutes;
				workTime -= lateMinutes;
				break;
			case "LEFT_EARLY":
				int earlyMinutes = 5 + random.nextInt(26); // 5 to 30 minutes
				attendanceEnd = attendanceEnd.minusMinutes(earlyMinutes);
				missedTime += earlyMinutes;
				workTime -= earlyMinutes;
				break;
			case "LATE_AND_LEFT_EARLY":
				int totalMissed = 5 + random.nextInt(26); // 5 to 30 minutes
				int halfMissed = totalMissed / 2;
				attendanceStart = attendanceStart.plusMinutes(halfMissed);
				attendanceEnd = attendanceEnd.minusMinutes(totalMissed - halfMissed);
				missedTime += totalMissed;
				workTime -= totalMissed;
				break;
			default:
				break;
		}

		// Early arrival
		if (status.equals("ATTENDED") && random.nextDouble() < 0.3) { // 30% chance to arrive early
			int earlyArrival = 5 + random.nextInt(16); // 5 to 20 minutes
			attendanceStart = attendanceStart.minusMinutes(earlyArrival);
			overTime += earlyArrival;
		}

		// Recalculate total worked minutes
		int totalWorkedMinutes = (int) Duration.between(attendanceStart, attendanceEnd).toMinutes();
		// Ensure workTime + breakTime = totalWorkedMinutes
		workTime = totalWorkedMinutes - breakTime;

		// Ensure workTime is not negative
		if (workTime < 0) workTime = 0;

		// Format timestamps
		String startTimestamp = Timestamp.valueOf(attendanceStart).toString();
		String endTimestamp = Timestamp.valueOf(attendanceEnd).toString();

		return String.format(
				"INSERT INTO hr_attendance_tb (id, store_id, emp_id, start_time, end_time, schedule_id, status, work_time, break_time, wage, missed_time, over_time) VALUES (%d, %d, %d, '%s', '%s', %d, '%s', %d, %d, %d, %d, %d);",
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

	// Get a random time on the hour or half-past
	private static LocalTime getRandomTime() {
		int hour = random.nextInt(24);
		int minute = random.nextBoolean() ? 0 : 30; // On the hour or half-past
		return LocalTime.of(hour, minute);
	}

	// Calculate break time based on work minutes (30 mins per 4 hours)
	private static int calculateBreakTime(int workMinutes) {
		// For every 4 hours (240 minutes) of work, ensure at least 30 minutes break
		int breakTime = (workMinutes / 240) * 30;
		return breakTime > 0 ? breakTime : 0;
	}

	// Assign Attendance Status based on distribution (excluding UNPLANNED_WORK and absents)
	private static String getStatus() {
		double rand = random.nextDouble() * 100;
		if (rand < 70) return "ATTENDED";
		rand -= 70;
		if (rand < 5) return "LEFT_EARLY";
		rand -= 5;
		if (rand < 5) return "LATE";
		rand -= 5;
		if (rand < 3) return "LATE_AND_LEFT_EARLY";
		// Remaining (2% +1% +4%) handled as absents
		return "ATTENDED"; // Default fallback
	}

	// Assign Absent Status based on distribution
	private static String getAbsentStatus() {
		double rand = random.nextDouble() * 100;
		if (rand < 2) return "UNAUTHORIZED_ABSENT";
		rand -= 2;
		if (rand < 1) return "SICK_ABSENT";
		rand -= 1;
		if (rand < 4) return "PERSONAL_ABSENT";
		return "UNAUTHORIZED_ABSENT"; // Default
	}

	// Inner class to hold status counts
	private static class AttendanceStatusCount {
		String status;
		int count;

		AttendanceStatusCount(String status, int count) {
			this.status = status;
			this.count = count;
		}
	}
}
