package org.example.solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14659 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		int count = 0;
		int shooter = 0;
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			int height = Integer.parseInt(token.nextToken());
			if (height > shooter) {
				shooter = height;
				max = Math.max(max, count);
				count = 0;
			} else {
				count++;
			}
		}
		System.out.println(Math.max(max, count));
	}

}
