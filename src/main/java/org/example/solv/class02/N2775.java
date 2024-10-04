package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k + 1][n + 1];
			for (int j = 0; j <= k; j++) {
				for (int l = 0; l <= n; l++) {
					if (j == 0) {
						apart[j][l] = l;
					} else {
						apart[j][l] = sum(apart[j - 1], l);
					}
				}
			}
			bw.write(apart[k][n] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static int sum(int[] nums, int l) {
		int sum = 0;
		for (int i = 0; i <= l; i++) {
			sum += nums[i];
		}
		return sum;
	}

}
