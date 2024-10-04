package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9849 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int resultX1 = 0;
		int resultX2 = 10000;
		int resultY1 = 0;
		int resultY2 = 10000;
		for (int i = 0; i < t; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			resultX1 = Math.max(resultX1, x1);
			resultX2 = Math.min(resultX2, x2);
			resultY1 = Math.max(resultY1, y1);
			resultY2 = Math.min(resultY2, y2);
		}
		int result = (resultX2 - resultX1) * (resultY2 - resultY1);
		if (resultX2 < resultX1 || resultY2 < resultY1) {
			result = 0;
		}
		System.out.println(result);
	}
}
