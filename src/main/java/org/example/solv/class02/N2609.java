package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		br.close();
		int[] numList = new int[2];
		numList[0] = Integer.parseInt(token.nextToken());
		numList[1] = Integer.parseInt(token.nextToken());
		Arrays.sort(numList);
		int min = 0;
		int max = 0;
		for (int i = 1; i <= numList[0]; i++) {
			if (numList[0] % i == 0 && numList[1] % i == 0) {
				max = i;
			}
		}
		for (int i = numList[1]; i <= numList[0] * numList[1]; i++) {
			if (i % numList[0] == 0 && i % numList[1] == 0) {
				min = i;
				break;
			}
		}
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
	}

}
