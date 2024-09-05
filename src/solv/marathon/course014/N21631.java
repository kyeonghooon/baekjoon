package solv.marathon.course014;

import java.util.Scanner;

public class N21631 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		long result = 0;
		if (a >= b - 1) {
			result = b;
		} else {
			result = a + 1;
		}
		System.out.println(result);
	}

}
