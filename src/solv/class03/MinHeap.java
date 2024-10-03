package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Long> list = new PriorityQueue<>();
		for (int i = 0; i < T; i++) {
			long input = Long.parseLong(br.readLine());
			if (input == 0) {
				if (list.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(list.poll()).append("\n");
				}
			} else {
				list.add(input);
			}
		}
		System.out.println(sb);
	}
	
}
