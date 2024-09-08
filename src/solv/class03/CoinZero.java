package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinZero {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			while (K >= coins[i]) {
				K -= coins[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
