package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MazeNavigation {

	static int[][] dp;
	static boolean[][] maze;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		maze = new boolean[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = line.charAt(j) == '1';
			}
		}
		dp();
		System.out.println(dp[n - 1][m - 1]);
	}

	static void dp() {
		dp[0][0] = 1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.addLast(new int[]{0, 0});
		while (!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int x = cur[0];
			int y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < maze.length && ny < maze[0].length && dp[nx][ny] == 0 && maze[nx][ny]) {
					dp[nx][ny] = dp[x][y] + 1;
					queue.addLast(new int[]{nx, ny});
				}
			}
		}
	}
}
