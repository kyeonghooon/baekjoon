package org.example.solv.marathon.course014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N26560 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.charAt(str.length() - 1) == '.');
			else {
				str += ".";
			}
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}

}
