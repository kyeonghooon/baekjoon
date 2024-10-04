package org.example.solv.marathon.course017;

import java.io.IOException;
import java.util.Scanner;

public class N16394 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		System.out.println(year - 1946);
		sc.close();
	}
}
