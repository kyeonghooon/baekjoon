package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountConnect {

	static boolean[][] lines;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		lines = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++){
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			lines[a][b] = lines[b][a] = true;
		}
		int count = 0;
		for (int i = 1; i <= N; i++){
			if (!visited[i]){
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
	private static void dfs(int n) {
		visited[n] = true;
		for (int i = 1; i < lines[n].length; i++) {
			if (lines[n][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

}
