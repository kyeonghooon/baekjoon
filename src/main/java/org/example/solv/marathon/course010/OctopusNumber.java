package org.example.solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OctopusNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String str = br.readLine();
			if (str.equals("#")) {
				break;
			}
			bw.write(toDecimal(str) + "");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static int toDecimal(String str) {
		int result = 0;
		final int OCT = 8;
		for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
			int oct = toOctal(str.charAt(i));
			result += (int)Math.pow(OCT, j) * oct;
		}
		return result;
	}
	public static int toOctal(char ch) {
		int result = 0;
		switch (ch) {
		case '-':
			result = 0;
			break;
		case '\\':
			result = 1;
			break;
		case '(':
			result = 2;
			break;
		case '@':
			result = 3;
			break;
		case '?':
			result = 4;
			break;
		case '>':
			result = 5;
			break;
		case '&':
			result = 6;
			break;
		case '%':
			result = 7;
			break;
		case '/':
			result = -1;
			break;
		}
		return result;
	}
}
