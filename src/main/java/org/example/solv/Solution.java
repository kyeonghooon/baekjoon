package org.example.solv;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	static boolean[] visited;

	public static int solution(int n) {
		int ans = 0;
		visited = new boolean[n + 1];
		ans = bfs(n);
		return ans;
	}

	public static int bfs(int n) {
		int min = Integer.MAX_VALUE;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.push(new int[]{n, 0});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int num = cur[0];
			int count = cur[1];
			visited[num] = true;
			if (num == 0) {
				min = Math.min(min, count);
				continue;
			}
			if (num < 0) continue;
			if (num % 2 == 0 && !visited[num / 2]) {
				queue.push(new int[]{num / 2, count});
			}
			if (!visited[num - 1]) {
				queue.push(new int[]{num - 1, count + 1});
			}
		}
		return min;
	}
}
