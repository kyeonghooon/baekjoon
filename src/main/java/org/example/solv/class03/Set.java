package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Set {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int set = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String command = token.nextToken();
			int x = 0;
			switch (command) {
			case "add":
				x = Integer.parseInt(token.nextToken());
				set |= (1 << x);
				break;
			case "remove":
				x = Integer.parseInt(token.nextToken());
				set &= ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(token.nextToken());
				System.out.println((set & (1 << x)) != 0 ? 1 : 0);
				break;
			case "toggle":
				x = Integer.parseInt(token.nextToken());
				set ^= (1 << x);
				break;
			case "all":
				set = (1 << 21) - 1;
				break;
			case "empty":
				set = 0;
				break;
			default:
				break;
			}
		}
	}

}
