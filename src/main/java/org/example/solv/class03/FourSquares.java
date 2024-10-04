package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {

//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Integer n = Integer.parseInt(br.readLine());
//		
//		int[] dp = new int[n + 1];
//		dp[0] = 0;
//		dp[1] = 1;
//		
//		for (int i = 2; i <= n; i++) {
//			dp[i] = i;
//			int min = dp[i];
//			for (int j = 0; j * j <= i; j++) {
//				min = Math.min(min, dp[i - j * j]);
//			}
//			dp[i] = min + 1;
//		}
//		System.out.println(dp[n]);
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		int maxSqrt = (int) Math.sqrt(n);
		if (maxSqrt == Math.sqrt(n)) {
			System.out.println(1);
			return;
		}
		for (int i = 1; i <= maxSqrt; i++) {
			if ((int) Math.sqrt(n - i * i) == Math.sqrt(n - i * i)) {
				System.out.println(2);
				return;
			}
		}
		for (int i = 1; i <= maxSqrt; i++) {
			int currentMaxSqrt = (int) Math.sqrt(n - i * i);
			for (int j = 1; j <= currentMaxSqrt; j++) {
				if ((int) Math.sqrt(n - i * i - j * j) == Math.sqrt(n - i * i - j * j)) {
					System.out.println(3);
					return;
				}
			}
		}
		System.out.println(4);
	}

}
