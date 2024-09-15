package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n + 1];
		int[] max = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		max[1] = stairs[1];
		if (n == 1) {
			System.out.println(max[1]);
			return;
		}
		max[2] = stairs[1] + stairs[2];
		for (int i = 3; i <= n; i++) {
			max[i] = Math.max(max[i - 2], max[i - 3] + stairs[i - 1]) + stairs[i];
		}
		System.out.println(max[n]);
	}

}
