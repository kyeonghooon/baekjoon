package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N6965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String replaceStr = "****";
		for (int i = 0; i < N; i++) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < tokens.length; j++) {
				if (tokens[j].length() == 4) {
					tokens[j] = replaceStr;
				}
				sb.append(tokens[j]).append(" ");
			}
			sb.append('\n').append('\n');
		}
		br.close();
		System.out.println(sb);
	}
}
