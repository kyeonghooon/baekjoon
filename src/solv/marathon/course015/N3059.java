package solv.marathon.course015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3059 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int sum = 0;
			String s = br.readLine();
			for (int j = 'A'; j <= 'Z'; j++) {
				if (s.indexOf(j) == -1) {
					sum += j;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
