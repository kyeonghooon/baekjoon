package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PoketmonMaster {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] nums = br.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int M = Integer.parseInt(nums[1]);
		Map<String, Integer> map = new HashMap<>();
		String[] names = new String[N];
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			names[i] = name;
			map.put(name, i + 1);
		}
		for (int i = 0; i < M; i++) {
			String q = br.readLine();
			if (q.matches("^[0-9]+$")) {
				sb.append(names[Integer.parseInt(q) - 1]).append("\n");
			} else {
				sb.append((map.get(q))).append("\n");
			}
		}
		System.out.println(sb);
	}

}
