package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solved_ac {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[31];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			list[num]++;
		}
		br.close();
		int ignore = (int) Math.round(n * 0.15);
		int count = n - ignore * 2;
		for (int i = 0; i < ignore; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[j] > 0) {
					list[j]--;
					break;
				}
			}
			for (int j = list.length - 1; j >= 0; j--) {
				if (list[j] > 0) {
					list[j]--;
					break;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i] * i;
		}
		System.out.println(Math.round((double) sum / count));;
	}

}
