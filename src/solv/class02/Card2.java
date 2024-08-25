package solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {

//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 1; i <= n; i++) {
//			queue.add(i);
//		}
//		while (queue.size() > 1) {
//			queue.poll();
//			queue.add(queue.poll());
//		}
//		System.out.println(queue.poll());
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(function(n));
	}
	public static int function(int n) {
		if (n == 1) {
			return 1;
		}
		int t = 2;
		while (n > t) {
			t *= 2;
		}
		if (n == t) {
			return n;
		} else {
			t /= 2;
			return (n - t) * 2;
		}
	}
}
