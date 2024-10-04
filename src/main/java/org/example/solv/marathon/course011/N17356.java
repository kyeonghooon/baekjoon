package org.example.solv.marathon.course011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17356 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		br.close();
		int A = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		double M = (double)(B - A) / 400;
		double result = 1 / (1 + Math.pow(10, M));
		System.out.println(result);
	}

}
