package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] times = br.readLine().split(":");
        int time1 = Integer.parseInt(times[0]);
        int time2 = Integer.parseInt(times[1]);
        int time3 = Integer.parseInt(times[2]);
        int result = 6;
        result -= check(time1);
        result -= check(time2);
        result -= check(time3);
        result = Math.max(0, result);
        System.out.println(result);
    }

    static int check(int time) {
        if (time < 0 || time > 59) {
            return 6;
        }
        if (time < 1 || time > 12) {
            return 2;
        }
        return 0;
    }

}
