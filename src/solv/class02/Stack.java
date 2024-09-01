package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			switch (str) {
			case "pop":
				if (deque.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.pop() + "\n");
				}
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if (deque.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
			case "top":
				if (deque.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.peek() + "\n");
				}
				break;
			default:
				deque.push(Integer.parseInt(str.substring(5)));
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
