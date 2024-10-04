package org.example.solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10102 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int A = 0;
		int B = 0;
		for (int i = 0; i < N; i++) {
			switch (str.charAt(i)) {
			case 'A':
				A++;
				break;
			case 'B':
				B++;
				break;
			}
		}
		String result;
		if (A > B) {
			result = "A";
		} else if (B > A) {
			result = "B";
		} else {
			result = "Tie";
		}
		System.out.println(result);
	}
}
