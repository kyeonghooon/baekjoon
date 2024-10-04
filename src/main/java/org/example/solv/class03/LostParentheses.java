package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		if (str.indexOf('-') > 0) {
			String plusStr = str.substring(0, str.indexOf('-'));
			String minusStr = str.substring(str.indexOf('-') + 1);
			String[] plusNumStr = plusStr.split("[-+]");
			String[] minusNumStr = minusStr.split("[-+]");
			for (int i = 0; i < plusNumStr.length; i++) {
				sum += Integer.parseInt(plusNumStr[i]);
			}
			for (int i = 0; i < minusNumStr.length; i++) {
				sum -= Integer.parseInt(minusNumStr[i]);
			}
		} else {
			String[] plusNumStr = str.split("[-+]");
			for (int i = 0; i < plusNumStr.length; i++) {
				sum += Integer.parseInt(plusNumStr[i]);
			}
		}
		System.out.println(sum);
	}
	
}
