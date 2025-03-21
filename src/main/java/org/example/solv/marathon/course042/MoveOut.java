package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveOut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }
        int[][] dp = new int[N + 1][M + 1];
        int maxK = M + N;
        for (int k = 2; k <= maxK; k++) {
            int start = Math.max(1, k - M);
            int maxI = Math.min(N + 1, k);
            for (int i = start; i < maxI; i++) {
                int j = k - i;
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + map[i][j];
            }
        }
        System.out.println(dp[N][M]);
    }
}
