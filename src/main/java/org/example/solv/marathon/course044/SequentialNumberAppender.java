package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequentialNumberAppender {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = 0;
        int mod = 0;
        while (N > 0) {
            idx++;
            int exp = (int) Math.pow(10, idx);
            mod += (N % 10) * exp / 10;
            N /= 10;
        }
        long count = 0;
        while (idx-- > 0) {
            count += 9 * (long) Math.pow(10, idx - 1) * idx;
        }
        int digits = Integer.toString(mod).length();
        count += (mod - (long) Math.pow(10, digits - 1) + 1) * digits;
        System.out.println(count);
    }
}
