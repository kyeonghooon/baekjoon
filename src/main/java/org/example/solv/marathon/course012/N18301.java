package org.example.solv.marathon.course012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N18301 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] N = br.readLine().split(" ");
		int n1 = Integer.parseInt(N[0]);
		int n2 = Integer.parseInt(N[1]);
		int n12 = Integer.parseInt(N[2]);
		System.out.println((n1 + 1) * (n2 + 1) / (n12 + 1) - 1);
	}

}
