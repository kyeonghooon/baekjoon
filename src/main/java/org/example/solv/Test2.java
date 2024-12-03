package org.example.solv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;

public class Test2 {


	public static void main(String[] args) {
		System.out.println('.' + '.'  + '.'  + '.');
		System.out.println('*' + '*'  + '*'  + '*');
	}

	public static int[][] solution(int n) {
		int[][] answer = {};
		Stack<Integer> stack1 = new Stack<>();
		for (int i = n; i > 0; i--) {
			stack1.push(i);
		}
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				int temp = stack1.pop();
			}
		}
		return answer;
	}
}
