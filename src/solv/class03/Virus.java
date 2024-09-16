package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Virus {

	private static boolean[][] network;
	private static boolean[] visited;
	private static int count;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computers = Integer.parseInt(br.readLine());
		int connections = Integer.parseInt(br.readLine());
		network = new boolean[computers + 1][computers + 1];
		visited = new boolean[computers + 1];
		for (int i = 0; i < connections; i++) {
			String[] splits = br.readLine().split(" ");
			int a = Integer.parseInt(splits[0]);
			int b = Integer.parseInt(splits[1]);
			network[a][b] = network[b][a] = true;
		}
		// dfs(1);
		bfs(1);
		System.out.println(count - 1);
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		count++;
		for (int i = 0; i < network.length; i++) {
			if (network[node][i] && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int node) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.addLast(node);
		visited[node] = true;
		count++;
		while (!queue.isEmpty()) {
			int currentNode = queue.pollFirst();
			for (int i = 0; i < network.length; i++) {
				if (network[currentNode][i] && !visited[i]) {
					visited[i] = true;
					queue.addLast(i);
					count++;
				}
			}
		}
	}

}
