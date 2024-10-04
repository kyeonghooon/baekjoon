package org.example.solv.marathon.course014;

import java.util.Scanner;

public class N21185 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n % 4 == 0) {
			System.out.println("Even");
		} else if (n % 2 == 0) {
			System.out.println("Odd");
		} else {
			System.out.println("Either");
		}
	}

}
