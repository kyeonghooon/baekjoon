package org.example.solv.programmers.lv2;

public class JadenCaseString {

	public static void main(String[] args) {

	}

	public static String solution(String s) {
		String answer = "";
		boolean check = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				check = true;
				sb.append(c);
				continue;
			}
			if (check && 'a' <= c && c <= 'z') {
				c -= 32;
			} else if (!check && 'A' <= c && c <= 'Z') {
                c += 32;
            }
			sb.append(c);
			check = false;
		}
		answer = sb.toString();
		return answer;
	}
}
