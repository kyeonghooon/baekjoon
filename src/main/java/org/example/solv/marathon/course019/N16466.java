package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N16466 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<Long> tickets = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			tickets.add(num);
		}
		long ticket = 1;
		while (tickets.contains(ticket)) {
			ticket++;
		}
		System.out.println(ticket);
	}
}
