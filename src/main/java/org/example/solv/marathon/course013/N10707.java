package org.example.solv.marathon.course013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10707 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int X = A * P;
		int Y = B;
		if (P >= C) {
			Y += (P - C) * D;
		}
		System.out.println(Math.min(X, Y));
	}

}
