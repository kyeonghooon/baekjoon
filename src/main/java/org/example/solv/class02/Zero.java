package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Zero {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				deque.push(n);
			} else {
				if (!deque.isEmpty()) {
					deque.pop();
				}
			}
		}
		int sum = 0;
		while(!deque.isEmpty()) {
			sum += deque.pop();
		}
		System.out.println(sum);
	}

}
