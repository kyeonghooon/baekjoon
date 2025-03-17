package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin2 {

    static int[] coins;
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= k; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 0; j < n; j++) {
                if (i + coins[j] <= k) {
                    dp[i + coins[j]] = Math.min(dp[i] + 1, dp[i + coins[j]]);
                }
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }

}
