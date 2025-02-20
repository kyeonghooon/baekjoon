package org.example.solv.marathon.course038;

import java.io.IOException;
import java.util.Arrays;

public class NoSuchPerson {

    static boolean[] forget;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int S = readInt();
        forget = new boolean[N + 1];
        int[][] arr = new int[M][2];
        for (int i = 0; i < M; i++) {
            int a = readInt();
            int t = readInt();
            arr[i][0] = a;
            arr[i][1] = t;
        }
        boolean[] submit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            if (arr[i][1] == 1 && !submit[arr[i][0]]) {
                int[][] sub = Arrays.copyOfRange(arr, i, arr.length);
                isForget(sub, S, arr[i][0]);
            } else if (arr[i][1] == 0) submit[arr[i][0]] = true;
        }
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (forget[i]) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) System.out.println(-1);
    }

    private static void isForget(int[][] arr, int S, int a) {
        for (int i = 0; i < arr.length && S > 0; i++) {
            if (arr[i][1] == 0) {
                if (arr[i][0] == a) {
                    return;
                } else {
                    S--;
                }
            }
        }
        if (S == 0) forget[a] = true;
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
