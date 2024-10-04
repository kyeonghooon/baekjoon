package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());
		System.out.println((int)Math.ceil((double)(V - A) / (A - B)) + 1);
	}

}
