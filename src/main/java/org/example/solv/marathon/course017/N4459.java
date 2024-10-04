package org.example.solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4459 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String[] ruleList = new String[T + 1];
		for (int i = 1; i <= T; i++) {
			ruleList[i] = br.readLine();
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int ruleNum = Integer.parseInt(br.readLine());
			if (ruleNum < 1 || ruleNum > T) {
				sb.append("Rule ").append(ruleNum).append(": No such rule\n");
			} else {
				sb.append("Rule ").append(ruleNum).append(": ").append(ruleList[ruleNum]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
