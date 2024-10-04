package org.example.solv.marathon.course013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N29196 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double k = Double.parseDouble(br.readLine());
		final double tolerance = 1.0E-6; 
		long q = 1_000_000_000;
		long p = (long) (k * q);
		double fraction = p / (double) q;
		if (Math.abs(fraction - k) > tolerance) {
			System.out.println("NO");
		} else {
			long gcd = gcd(p,q);
			p /= gcd;
			q /= gcd;
			System.out.println("YES");
			System.out.println(p + " " + q);
		}
	}
	
	public static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

}
