package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FruitTanghulu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] splits = br.readLine().split(" ");
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(splits[i]);
		}
		int[] count = new int[10];
		int distinct = 0;
		int left = 0;
		int maxLen = 0;
		for (int right = 0; right < N; right++) {
			if (count[list[right]] == 0) {
				distinct++;
			}
			count[list[right]]++;
			while (distinct > 2) {
				count[list[left]]--;
				if (count[list[left]] == 0) {
					distinct--;
				}
				left++;
			}
			maxLen = Math.max(maxLen, right - left + 1);
		}
		System.out.println(maxLen);
	}
	
}
