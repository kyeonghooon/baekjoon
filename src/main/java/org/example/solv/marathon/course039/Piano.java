package org.example.solv.marathon.course039;

import java.io.IOException;

public class Piano {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N + 1];
        int prev = readInt();
        int count = 0;
        for (int i = 1; i < N; i++) {
            int cur = readInt();
            if (prev > cur) arr[i] = ++count;
            else arr[i] = count;
            prev = cur;
        }
        int Q = readInt();
        StringBuilder sb = new StringBuilder();
        while(Q--> 0) {
            int start = readInt();
            int end = readInt();
            start = start - 1;
            end = end - 1;
            sb.append(arr[end] - arr[start]).append("\n");
        }
        System.out.println(sb);
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
