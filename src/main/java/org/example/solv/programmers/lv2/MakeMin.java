package org.example.solv.programmers.lv2;

import java.util.Arrays;

public class MakeMin {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2 };
		int[] B = new int[] { 3, 4 };
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < B.length; i++) {
			answer += A[i] * B[B.length - 1 - i];
		}
		return answer;
	}

}
