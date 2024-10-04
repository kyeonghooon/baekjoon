package org.example.solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N25641 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int countS = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 's') countS++;
		}
		int countN = N - countS;
		while (countS != countN) {
			if (str.charAt(0) == 's') countS--;
			else countN--;
			str = str.substring(1);
		}
		System.out.println(str);
	}
}
