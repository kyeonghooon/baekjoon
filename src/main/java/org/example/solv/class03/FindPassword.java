package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FindPassword {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		StringBuilder sb = new StringBuilder(M * 20);
		Map<String, String> map = new HashMap<>(N);
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			String site = token.nextToken();
			String password = token.nextToken();
			map.put(site, password);
		}
		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(map.get(site)).append("\n");
		}
		System.out.println(sb);
	}

}
