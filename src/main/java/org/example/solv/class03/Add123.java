package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add123 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			sb.append(f(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int f(int n) {
		if (n == 1) return 1;
		else if (n == 2) return 2;
		else if (n == 3) return 4;
		else return f(n - 1) + f(n - 2) + f(n - 3);
	}

}
