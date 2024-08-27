package solv.marathon.course13;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class N13277 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		sc.close();
		System.out.println(n.multiply(m));
	}

}
