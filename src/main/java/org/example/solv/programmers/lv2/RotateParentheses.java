package org.example.solv.programmers.lv2;

import java.util.*;

public class RotateParentheses {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (test(s, i)) answer++;
        }
        return answer;
    }
    public boolean test(String s, int start) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt((i + start) % s.length());
            switch (c) {
                case '(','{','[':
                    stack.add(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && c - 1 == stack.peek()) {
                        stack.pop();
                    } else return false;
                    break;
                case '}',']':
                    if (!stack.isEmpty() && c - 2 == stack.peek()) {
                        stack.pop();
                    } else return false;
                    break;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
