package solv.marathon.course015;

import java.util.Scanner;

public class N26082 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		System.out.println((B / A) * C * 3);
	}
}
