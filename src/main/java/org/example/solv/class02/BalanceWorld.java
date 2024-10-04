package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalanceWorld {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			if (isBalance(str)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean isBalance(String str) {
		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				} 
				stack.pop();
			} else if (ch == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return false;
				} 
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
