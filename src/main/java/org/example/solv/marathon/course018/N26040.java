package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N26040 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer token = new StringTokenizer(br.readLine());
		while (token.hasMoreTokens()) {
			Character c = token.nextToken().charAt(0);
			Character low = (char) (c + 32);
			str = str.replaceAll(c.toString(), low.toString());
		}
		System.out.println(str);
	}
}
