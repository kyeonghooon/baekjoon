package org.example.solv.marathon.course038;

import java.io.IOException;
import java.util.*;

public class DequeSort {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int result = 0;
        for (int i = 0; i < N; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (arr[i] == sorted[j]) {
                    sorted[j] = 1001;
                    break;
                }
            }
            if (j == 0) {
                if (sorted[j + 1] != 1001) {
                    result++;
                }
            } else if (j == N - 1) {
                if (sorted[j - 1] != 1001) {
                    result++;
                }
            } else if (sorted[j - 1] != 1001 && sorted[j + 1] != 1001) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        boolean negative = false;
        if (c == '-') {
            negative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return negative ? -rs : rs;
    }

}
