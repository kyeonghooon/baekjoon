package org.example.solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15272 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if (str.contains("ss")) {
			System.out.println("hiss");
		} else {
			System.out.println("no hiss");
		}
	}
}
