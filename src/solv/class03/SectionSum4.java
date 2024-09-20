package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionSum4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		long[] prefix = new long[N + 1];
		token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i - 1] + Integer.parseInt(token.nextToken());
		}
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			long sum = prefix[end] - prefix[start - 1];
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}

}
