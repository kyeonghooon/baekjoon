package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N30677 {

	private static int C;
	private static int R;
	private static int[] base;
	private static int[] s;
	private static int[] p;
	private static int[] skill;

	private static int combo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		base = new int[K];
		s = new int[K];
		p = new int[K];
		skill = new int[K];

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			base[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			s[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			p[i] = Integer.parseInt(token.nextToken());
		}
		combo = 0;
		long sum = 0;
		int piro = 0;
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine()) - 1;
			if (k == -1) {
				combo = 0;
				piro -= R;
				if (piro < 0) {
					piro = 0;
				}
				continue;
			}
			sum += make(k);
			combo++;
			piro += p[k];
			if (piro > 100) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(sum);
	}

	private static long make(int k){
		long comboFactor = 100 + combo * C;
		long skillFactor = 100 + skill[k] * s[k];
		skill[k]++;
		return (base[k] * comboFactor * skillFactor) / 10000;
	}

}
