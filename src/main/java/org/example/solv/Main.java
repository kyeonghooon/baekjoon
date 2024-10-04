package org.example.solv;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(9);
		System.out.println(queue);
		queue.add(1);
		System.out.println(queue);
		queue.add(3);
		System.out.println(queue);
		queue.add(2);
		System.out.println(queue);
		queue.add(4);
		System.out.println(queue);
		queue.add(7);
		System.out.println(queue);
		queue.add(8);
		System.out.println(queue);
		queue.add(5);
		System.out.println(queue);
		queue.add(6);
		System.out.println(queue);
		System.out.println("===========================================");
		while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
	}
}
