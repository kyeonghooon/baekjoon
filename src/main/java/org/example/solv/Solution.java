package org.example.solv;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(10000000));
	}

	public static String solution(int n) {
		String s = String.valueOf(n);
		int mod = s.length() % 3;
		int size = s.length() / 3 + 1;
		String[] list = new String[size];
		list[0] = s.substring(0, mod);
		for (int i = 0; i < size - 1; i++) {
			list[i + 1] = s.substring(i * 3 + mod, (i + 1) * 3 + mod);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(list[i]).append(".");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

}
