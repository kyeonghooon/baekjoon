package solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N27648 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		if (N + M - 1 > K) {
			System.out.println("NO");
		} else {
			sb.append("YES\n");
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= M; j++) {
					sb.append(i + j);
					if (j != M) sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}
}
