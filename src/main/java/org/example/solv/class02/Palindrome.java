package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Palindrome {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String numStr = br.readLine();
			if (numStr.equals("0")) {
				break;
			}
			int[] digit = new int[numStr.length()];
			for (int i = 0; i < digit.length; i++) {
				digit[i] = numStr.charAt(i) - '0';
			}
			String msg = null;
			switch (digit.length) {
			case 1 :
				msg = "yes";
				break;
			case 2 :
				if (digit[0] == digit[1]) {
					msg = "yes";
				} else {
					msg = "no";
				}
				break;
			case 3 :
				if (digit[0] == digit[2]) {
					msg = "yes";
				} else {
					msg = "no";
				}
				break;
			case 4 :
				if (digit[0] == digit[3] && digit[1] == digit[2]) {
					msg = "yes";
				} else {
					msg = "no";
				}
				break;
			case 5 :
				if (digit[0] == digit[4] && digit[1] == digit[3]) {
					msg = "yes";
				} else {
					msg = "no";
				}
				break;
			}
			bw.write(msg);
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
