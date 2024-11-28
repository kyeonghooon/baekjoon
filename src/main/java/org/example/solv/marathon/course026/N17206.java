package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17206 {

    static int[] dp;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp = new int[80_001];
        index = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(st.nextToken());
            int sum = dp(n);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    public static int dp(int n) {
        if (n <= index) {
            return dp[n];
        }
        for (int i = index; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i % 3 == 0 || i % 7 == 0) {
                dp[i] += i;
            }
        }
        index = n;
        return dp[n];
    }

}
