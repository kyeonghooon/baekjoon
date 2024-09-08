package solv.marathon.course014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10995 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				sb.append(" ");
			}
			for (int j = 0; j < n; j++) {
				sb.append("*").append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
