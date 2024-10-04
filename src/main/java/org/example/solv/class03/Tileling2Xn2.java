package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tileling2Xn2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		final int mod = 10007;
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % mod ;
		}
		System.out.println(dp[n]);
	}
	
}
