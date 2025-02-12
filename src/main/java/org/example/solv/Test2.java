package org.example.solv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;

public class Test2 {


    public static void main(String[] args) {
        System.out.println(Test2.solution(new int[]{730, 855, 700, 720}, new int[][]{{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}}, 1));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < timelogs.length; i++) {
            int sTime = schedules[i] / 100 * 60 + schedules[i] % 100 + 10;
            for (int j = 0; j < 7; j++) {
                if (startday + j == 6 || startday + j == 7) continue;
                int aTime = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                if (sTime < aTime) break;
                if (j == 6) answer++;
            }
        }
        return answer;
    }
}
