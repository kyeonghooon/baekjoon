package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FizzBuzz {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		if (isNumberic(str1)) {
			n1 = Integer.parseInt(str1);
			n4 = n1 + 3;
		} else if (isNumberic(str2)) {
			n2 = Integer.parseInt(str2);
			n4 = n2 + 2;
		} else if (isNumberic(str3)) {
			n3 = Integer.parseInt(str3);
			n4 = n3 + 1;
		}
		bw.write(fizzbuzz(n4));
		bw.flush();
		bw.close();
	}

	public static boolean isNumberic(String str) {
		switch (str) {
		case "Fizz":
			return false;
		case "Buzz":
			return false;
		case "FizzBuzz":
			return false;
		default:
			return true;
		}
	}
	
	public static String fizzbuzz(int n) {
		if (n % 3 == 0 && n % 5 == 0) {
			return "FizzBuzz";
		} else if (n % 3 == 0 && n % 5 != 0) {
			return "Fizz";
		} else if (n % 3 != 0 && n % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(n);
		}
	}
}
