package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnknownOne {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] nums = br.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int M = Integer.parseInt(nums[1]);
		String[] noListen = new String[N];
		String[] noSee = new String[M];
		for (int i = 0; i < N; i++) {
			noListen[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			noSee[i] = br.readLine();
		}
		Arrays.sort(noListen);
		Arrays.sort(noSee);
		int n = 0, m = 0, result = 0;
		while (true) {
			if (n >= N || m >= M) {
				break;
			}
			int comp = noListen[n].compareTo(noSee[m]);
			if (comp == 0) {
				sb.append(noListen[n]).append("\n");
				result++;
				n++;
				m++;
			} else if (comp > 0) {
				m++;
			} else {
				n++;
			}
		}
		System.out.println(result);
		System.out.println(sb);
	}

}
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		String[] nums = br.readLine().split(" ");
//		int N = Integer.parseInt(nums[0]);
//		int M = Integer.parseInt(nums[1]);
//		Set<String> set = new HashSet<>();
//		List<String> result = new ArrayList<>();
//		for (int i = 0; i < N; i++) {
//			set.add(br.readLine());
//		}
//		for (int i = 0; i < M; i++) {
//			String name = br.readLine();
//			if (!set.add(name)) {
//				result.add(name);
//			}
//		}
//		Collections.sort(result);
//		sb.append(result.size()).append("\n");
//		for (String string : result) {
//			sb.append(string).append("\n");
//		}
//		System.out.println(sb);
//	}
//
//}
