package solv.marathon.course014;

import java.util.Scanner;

public class N27960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		int C = A ^ B;
		System.out.println(C);
	}

}
