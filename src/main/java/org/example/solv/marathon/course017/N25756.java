package org.example.solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25756 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		double V = 0;
		for (int i = 0; i < N; i++) {
			double A = Double.parseDouble(token.nextToken()) / 100;
			V = calculate(V, A);
			sb.append(String.format("%.6f", V * 100)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static double calculate(double V, double A) {
		double result = 1 - ((1 - V) * (1 - A));
		return result;
	}
}
