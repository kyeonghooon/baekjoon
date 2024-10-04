package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(function(N));
	}
	public static int function(int N) {
		int div5 = N / 5;
		for (int i = div5; i >= 0; i--) {
			for (int j = (N - i * 5) / 3; j >= 0; j--) {
				if ((i * 5 + j * 3) == N) {
					return i + j;
				}
			}
		}
		return -1;
	}

}
