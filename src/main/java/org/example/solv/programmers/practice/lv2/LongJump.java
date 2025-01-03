package org.example.solv.programmers.practice.lv2;

public class LongJump {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n];
        if (n == 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer = (dp[n - 1] + dp[n - 2]) % 1234567;
        return answer;
    }
}