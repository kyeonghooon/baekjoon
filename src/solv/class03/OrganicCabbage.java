package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {

	static boolean[][] field;
	static boolean[][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(token.nextToken());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			field = new boolean[M][N];
			visited = new boolean[M][N];
			for (int j = 0; j < K; j++) {
				token = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				field[x][y] = true;
			}
			int count = 0;
			for (int j = 0; j < field.length; j++) {
				for (int k = 0; k < field[j].length; k++) {
					if (field[j][k] && !visited[j][k]) {
						// dfs(j, k);
						bfs(j, k);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < field.length && ny < field[0].length) {
				if (field[nx][ny] && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx >= 0 && ny >= 0 && nx < field.length && ny < field[0].length) {
					if (field[nx][ny] && !visited[nx][ny]) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

}
