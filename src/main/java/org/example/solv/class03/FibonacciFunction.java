package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciFunction {

	private static int[][] save;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		save = new int[41][2];
		setSave();
		for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(save[num][0]).append(" ").append(save[num][1]).append("\n");
        }
		System.out.println(sb);
	}
	
	private static void setSave() {
		save[0][0] = 1;
		save[0][1] = 0;
		save[1][0] = 0;
		save[1][1] = 1;
		
		for (int i = 2; i < 41; i++) {
			save[i][0] = save[i - 1][0] + save[i - 2][0];
			save[i][1] = save[i - 1][1] + save[i - 2][1];
		}
	}

}
