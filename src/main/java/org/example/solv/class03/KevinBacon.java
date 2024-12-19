package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class KevinBacon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		boolean[][] connected = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			connected[a][b] = connected[b][a] = true;
		}
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			int sum = 0;
			ArrayDeque<int[]> queue = new ArrayDeque<>();
			for (int j = 1; j <= N; j++) {
				if (connected[i][j]) {
					queue.add(new int[] {j, 1});
					visited[j] = true;
					sum += 1;
				}
			}
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (connected[cur[0]][j] && !visited[j]) {
						queue.add(new int[] {j, cur[1] + 1});
						visited[j] = true;
						sum += cur[1] + 1;
					}
				}
			}
			if (sum < min) {
				min = sum;
				result = i;
			}
		}
		System.out.println(result);
	}
	
}
