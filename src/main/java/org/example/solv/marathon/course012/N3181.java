package org.example.solv.marathon.course012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strList = new String[] { "i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili" };
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		String[] tokens = str.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (i == 0) {
				sb.append((tokens[i].charAt(0) + "").toUpperCase());
			} else {
				boolean check = true;
				for (String string : strList) {
					if (string.equals(tokens[i])) {
						check = false;
					}
				}
				if (check) {
					sb.append((tokens[i].charAt(0) + "").toUpperCase());
				}
			}
		}
		System.out.println(sb);
	}

}
