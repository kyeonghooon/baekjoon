package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N15761 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		Integer[] list = new Integer[t];
		for (int i = 0; i < t; i++) {
			list[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(list, Collections.reverseOrder());
		int line = 0;
		for (int i = 0; i < list.length; i++) {
			if (line <= list[i]){
				line++;
			}
		}
		System.out.println(line);
	}
}
