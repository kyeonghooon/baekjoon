package org.example.solv.marathon.course038;

import java.io.IOException;

public class Year2007 {

    public static void main(String[] args) throws IOException {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekDay = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int x = readInt();
        int y = readInt();
        int day = y;
        for (int i = 0; i < x - 1; i++) {
            day += days[i];
        }
        System.out.println(weekDay[day % 7]);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
