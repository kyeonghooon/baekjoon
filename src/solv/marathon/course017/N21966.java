package solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N21966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String front = null;
		String ellipsis = null;
		String back = null;
		if (T <= 25) {
			sb.append(str);
		} else {
			front = str.substring(0, 11);
			ellipsis = str.substring(11, T - 11);
			back = str.substring(T - 11);
			if (ellipsis.substring(1, ellipsis.length() - 1).contains(".")) {
				front = str.substring(0, 9);
				back = str.substring(T - 10);
				sb.append(front).append("......").append(back);
			} else {
				sb.append(front).append("...").append(back);
			}
		}
		System.out.println(sb);
		
	}

}
