package solv.programmers.lv2;

import java.util.Stack;

public class CorrectParentheses {

	public static void main(String[] args) {
		System.out.println(solution("(()("));
	}

	static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				stack.add(c);
			} else {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return answer;
	}

}
