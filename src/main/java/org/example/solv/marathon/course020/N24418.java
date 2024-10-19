package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24418 {

    private static int[][] matrix;
    private static int countRec = 1;
    private static int countDP = 0;
    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findMaxPathRec(N,N);
        System.out.println(countRec + " " + (N * N));
    }

    private static void findMaxPathRec(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        countRec++;
        findMaxPathRec(i - 1, j);
        findMaxPathRec(i, j - 1);
    }

    private static void findMaxPathDP(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

}
