package org.example.solv.marathon.course040;

import java.io.IOException;

public class Power {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int left = N - 1;
        int right = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int power = readInt();
            if (power > max) {
                max = power;
                left = right = i;
            } else if (power == max) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        int B = left;
        int R = N - 1 - right;
        if (B > R) System.out.println("B");
        else if (R > B) System.out.println("R");
        else System.out.println("X");
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
