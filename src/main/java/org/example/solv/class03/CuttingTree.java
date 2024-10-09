package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingTree {

	private static int[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		list = new int[N];
		token = new StringTokenizer(br.readLine());
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(token.nextToken());
			right = Math.max(right, list[i]);
		}
		int height = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = cut(mid);
			if (sum < M) {
				right = mid - 1;
			} else {
				height = Math.min(height, mid);
				left = mid + 1;
			}
		}
		System.out.println(right);
	}

	private static long cut(int mid) {
		long sum = 0;
		for (int i : list) {
			sum += Math.max(0, i - mid);
		}
		return sum;
	}
	
}
