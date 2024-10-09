package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		int result = 28 - R * 8 - S * 3;
		System.out.println(result < 0 ? -result : 0);
	}
}
