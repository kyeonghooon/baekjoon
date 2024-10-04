package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FindNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		List<Integer> N = new ArrayList<>();
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < count; i++) {
			N.add(Integer.parseInt(token.nextToken()));
		}
		Collections.sort(N);
		count = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine());
		br.close();
		for (int i = 0; i < count; i++) {
			int M = Integer.parseInt(token.nextToken());
			int check = Collections.binarySearch(N, M);
			if (check >= 0) {
				bw.write("1");
			} else {
				bw.write("0");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
