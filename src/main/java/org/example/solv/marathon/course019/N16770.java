package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16770 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] totalCount = new int[1001];
		int maxCount = 0;
		StringTokenizer token = null;
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int count = Integer.parseInt(token.nextToken());
			for (int j = start; j <= end ; j++) {
				totalCount[j] += count;
				maxCount = Math.max(maxCount, totalCount[j]);
			}
		}
		System.out.println(maxCount);
	}
}
