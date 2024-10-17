package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine().trim();
		sb.append(Integer.toBinaryString(str.charAt(0) - '0'));
		for (int i = 1; i < str.length(); i++) {
			String bin = Integer.toBinaryString(str.charAt(i) - '0');
			while (bin.length() < 3) {
				bin = "0" + bin;
			}
			sb.append(bin);
		}
		System.out.println(sb);
	}
}
