package org.example.solv.marathon.course023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N24460 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = readInt();
            }
        }
        System.out.println(dfs(0, 0, N - 1, N - 1));
    }

    static int dfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return arr[startX][startY];
        }
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        int[] values = new int[4];
        values[0] = dfs(startX, startY, midX, midY);
        values[1] = dfs(midX + 1, startY, endX, midY);
        values[2] = dfs(startX, midY + 1, midX, endY);
        values[3] = dfs(midX + 1, midY + 1, endX, endY);
        return findSecondSmallest(values);
    }

    static int findSecondSmallest(int[] values) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int value : values) {
            if (value < first) {
                second = first;
                first = value;
            } else if (value < second) {
                second = value;
            }
        }
        return second;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
