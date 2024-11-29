package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0) {
				priorityQueue.add(n);
			} else {
				if (!priorityQueue.isEmpty()) {
					sb.append(priorityQueue.poll()).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
}
