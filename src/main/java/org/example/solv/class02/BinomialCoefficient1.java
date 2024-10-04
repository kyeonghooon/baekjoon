package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinomialCoefficient1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int result = factorial(N) / (factorial(N - K) * factorial(K));
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
	public static int factorial(int max) {
		int result = 1;
		for (int i = 1; i <= max; i++) {
			result *= i;
		}
		return result;
	}
}
