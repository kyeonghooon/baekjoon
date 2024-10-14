package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N25441 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] aList = new int[N];
		int[] bList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			aList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			bList[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			if (aList[i] == bList[i]) continue;
			count++;
			int x = aList[i] ^ bList[i];
			aList[i + 1] = x ^ aList[i + 1];
		}
		if (aList[N - 1] != bList[N - 1]) count = -1;
		System.out.println(count);
	}
}
