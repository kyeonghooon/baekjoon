package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS {

	static class Node {
		int num;
		Node link;

		public Node(int num, Node link) {
			this.num = num;
			this.link = link;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static boolean[] visitedDfs;
	static boolean[] visitedBfs;
	static Node[] head;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		head = new Node[N + 1];
		visitedDfs = new boolean[N + 1];
		visitedBfs = new boolean[N + 1];
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			init(from, to);
			init(to, from);
		}
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	private static void init(int n1, int n2) {
		// 해당 번호에 노드가 없다면 하나 넣음 --> 바로 헤드값
		if (head[n1] == null) {
			head[n1] = new Node(n2, null);
			return;
		}
		// 현재 넣으려고 하는 값이 헤드값 보다 작다면 헤드 교체
		if (n2 < head[n1].num) {
			// 기존의 헤드를 링크시킴
			head[n1] = new Node(n2, head[n1]);
			return;
		}
		Node temp = head[n1];
		while (temp != null) {

			// 현재 노드가 가리키는 링크가 없다면 현재 넣으려는 값으로 링크 달기
			if (temp.link == null) {
				temp.link = new Node(n2, null);
				return;
			}

			// 헤드가 가리키는 링크의 num값이 현재 넣으려는 값보다 크다면 링크 교체
			if (n2 < temp.link.num) {
				temp.link = new Node(n2, temp.link);
				return;
			}

			// 위의 모든 조건에 걸리지 않았다면 다음링크로 진행
			temp = temp.link;
		}
	}

	private static void dfs(int V) {
		visitedDfs[V] = true;
		sb.append(V).append(" ");
		Node next = head[V];
		while (next != null) {
			if (!visitedDfs[next.num]) {
				dfs(next.num);
			}
			next = next.link;
		}
	}

	private static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		sb.append(V).append(" ");
		visitedBfs[V] = true;
		while (!queue.isEmpty()) {
			int curNum = queue.poll();
			Node next = head[curNum];
			while (next != null) {

				if (!visitedBfs[next.num]) {
					queue.add(next.num);
					sb.append(next.num).append(" ");
					visitedBfs[next.num] = true;
				}
				next = next.link;
			}
		}
	}

}

//public class DFSnBFS {
//
//	private static StringBuilder sb = new StringBuilder();
//	private static List<Integer>[] lines;
//	private static boolean[] visitedDfs;
//	private static boolean[] visitedBfs;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer token = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(token.nextToken());
//		lines = new ArrayList[N + 1];
//		for (int i = 1; i <= N; i++) {
//			lines[i] = new ArrayList<>();
//		}
//		visitedDfs = new boolean[N + 1];
//		visitedBfs = new boolean[N + 1];
//		int M = Integer.parseInt(token.nextToken());
//		int V = Integer.parseInt(token.nextToken());
//		for (int i = 0; i < M; i++) {
//			token = new StringTokenizer(br.readLine());
//			int n1 = Integer.parseInt(token.nextToken());
//			int n2 = Integer.parseInt(token.nextToken());
//			lines[n1].add(n2);
//			lines[n2].add(n1);
//		}
//		for (int i = 1; i <= N; i++) {
//			Collections.sort(lines[i]);
//		}
//		dfs(V);
//		sb.append("\n");
//		bfs(V);
//		System.out.println(sb);
//	}
//
//	private static void dfs(int V) {
//		visitedDfs[V] = true;
//		sb.append(V).append(" ");
//		for (int next : lines[V]) {
//			if (!visitedDfs[next]) {
//				dfs(next);
//			}
//		}
//	}
//
//	private static void bfs(int V) {
//		Queue<Integer> queue = new LinkedList<>();
//		queue.add(V);
//		sb.append(V).append(" ");
//		visitedBfs[V] = true;
//		while (!queue.isEmpty()) {
//			int curNum = queue.poll();
//			for (int next : lines[curNum]) {
//				if (!visitedBfs[next]) {
//					queue.add(next);
//					sb.append(next).append(" ");
//					visitedBfs[next] = true;
//				}
//			}
//		}
//	}
//
//}
