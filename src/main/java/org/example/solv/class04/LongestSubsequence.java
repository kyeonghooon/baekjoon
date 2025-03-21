package org.example.solv.class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(input[i]);
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int answer = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
