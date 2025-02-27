package org.example.solv.marathon.course039;

import java.io.IOException;

public class GimbobStair {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            int next = i + 1;
            dp[next] = dp[next] == 0 ? dp[i] + 1 : Math.min(dp[next], dp[i] + 1);
            next = i + i / 2;
            if (next > n) continue;
            dp[next] = dp[next] == 0 ? dp[i] + 1 : Math.min(dp[next], dp[i] + 1);
            if (next == n) break;
        }
        if (dp[n] > k) System.out.println("water");
        else System.out.println("minigimbob");
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
