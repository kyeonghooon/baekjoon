package org.example.solv.marathon.course023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int startYear = 2019;
        int endYear = Integer.parseInt(br.readLine());
        int count = 0;
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(year, month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
