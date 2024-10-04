package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackSequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int index = 1;
		boolean check = true;
		for (int i = 1; i <= count; i++) {
			int num = Integer.parseInt(br.readLine());
			while (index <= num) {
				stack.push(index++);
				sb.append("+\n");
			}
			if (stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				check = false;
			}
		}
		br.close();
		bw.write(check ? sb.toString() : "NO");
		bw.flush();
		bw.close();
	}

}
