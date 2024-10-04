package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FashionKing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				String input = br.readLine();
				String type = input.substring(input.indexOf(" ") + 1);
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			int result = 1;
			for (int count : map.values()) {
				result *= (count + 1);
			}
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb);
	}

}
