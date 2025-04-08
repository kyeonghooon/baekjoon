package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctSumCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int mod = 100999;
        int[] dp = new int[max + 1];
        dp[0] = 1;

        for (int k = 1; k <= max; k++) {
            for (int i = max; i >= k; i--) {
                dp[i] = (dp[i] + dp[i - k]) % mod;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
