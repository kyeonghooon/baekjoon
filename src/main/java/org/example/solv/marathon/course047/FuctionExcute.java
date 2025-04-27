package org.example.solv.marathon.course047;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FuctionExcute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String input = null;
        StringBuilder sb = new StringBuilder();
        int[][][] dp = new int[21][21][21];
        data(dp);
        while (!(input = br.readLine()).equals("-1 -1 -1")) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int result = 0;
            if (a <= 0 || b <= 0 || c <= 0) {
                result = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                result = dp[20][20][20];
            } else {
                result = dp[a][b][c];
            }
            sb.append(String.format("w(%d, %d, %d) = %d%n", a, b, c, result));
        }
        System.out.print(sb);
    }

    private static void data(int[][][] dp) {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1]
                                      + dp[i][j - 1][k - 1]
                                      - dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k]
                                      + dp[i - 1][j - 1][k]
                                      + dp[i - 1][j][k - 1]
                                      - dp[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
    }

}
