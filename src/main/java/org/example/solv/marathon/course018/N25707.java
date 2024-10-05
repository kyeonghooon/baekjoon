package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25707 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int max = 0;
		int min = 1_000_000_000;
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(token.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println((max - min) * 2);
	}
}
