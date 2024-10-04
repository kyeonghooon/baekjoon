package org.example.solv.marathon.course013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17388 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int H = Integer.parseInt(token.nextToken());
		if (S + K + H >= 100) {
			System.out.println("OK");
		} else {
			int min = Math.min(Math.min(S, K), H);
			if (min == S) {
				System.out.println("Soongsil");
			} else if (min == K) {
				System.out.println("Korea");
			} else {
				System.out.println("Hanyang");
			}
		}
	}

}
