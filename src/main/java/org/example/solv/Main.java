package org.example.solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < 288; i++) {
			sb.append("\"").append(br.readLine()).append("\", ");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
}
