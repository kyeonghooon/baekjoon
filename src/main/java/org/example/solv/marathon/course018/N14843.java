package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class N14843 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			double S = Double.parseDouble(token.nextToken());
			double A = Double.parseDouble(token.nextToken());
			double T = Double.parseDouble(token.nextToken());
			double M = Double.parseDouble(token.nextToken());
			double result = S;
			result *= (1 + 1 / A);
			result *= (1 + M / T);
			result /= 4.0;
			sum += result;
		}
		int P = Integer.parseInt(br.readLine());
		int count = 1;
		for (int i = 0; i < P; i++) {
			double d = Double.parseDouble(br.readLine());
			if (d > sum) {
				count++;
			}
		}
		String name = count <= (P + 1) * 0.15 ? "Younghoon \"The God\"" : "Younghoon";
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedValue = df.format(sum);
		System.out.println("The total score of " + name + " is " + formattedValue + ".");
	}
}
