package org.example.solv.marathon.course015;

import java.util.Scanner;

public class N17256 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int az = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		int cz = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		sb.append(cx - az).append(" ").append(cy / ay).append(" ").append(cz - ax);
		System.out.println(sb);
	}
}
