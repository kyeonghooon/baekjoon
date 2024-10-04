package org.example.solv.marathon.course015;

import java.util.Scanner;

public class N28444 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int I = sc.nextInt();
		int A = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		System.out.println(H * I - A * R * C);
	}
}
