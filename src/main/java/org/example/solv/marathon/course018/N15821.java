package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15821 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		double[] length = new double[N];
		for (int i = 0; i < N; i++) {
			int T = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			double max = 0;
			for (int j = 0; j < T; j++) {
				double A = Double.parseDouble(st.nextToken());
				double B = Double.parseDouble(st.nextToken());
				max = Math.max(max, (A * A + B * B));
			}
			length[i] = max;
		}
		Arrays.sort(length);
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedValue = df.format(length[K - 1]);
		System.out.println(formattedValue);
	}
}
