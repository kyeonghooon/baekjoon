package solv.marathon.course012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10797 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine().trim();
		String str = br.readLine().trim();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (num.equals(str.charAt(i) + "")) {
				count++;
			}
		}
		System.out.println(count);
	}

}
