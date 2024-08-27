package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Parentheses {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			if (isVPS(str)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean isVPS(String str) {
		Deque<Character> deque = new ArrayDeque<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				deque.push(ch);
			} else if (ch == ')') {
				if (deque.isEmpty() || deque.peek() != '(') {
					return false;
				} 
				deque.pop();
			}
		}
		return deque.isEmpty();
	}
}
