package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Average {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] scoreList = new int[count];
		int max = 0;
		int sum = 0;
		// max 값 설정 & 합계 구하기
		for (int i = 0; i < scoreList.length; i++) {
			scoreList[i] = Integer.parseInt(token.nextToken());
			sum += scoreList[i];
			if (max < scoreList[i]) {
				max = scoreList[i];
			}
		}
		double avg = ((double) sum / (count * max)) * 100;
		bw.write(String.valueOf(avg));
		bw.flush();
		bw.close();
	}

}
