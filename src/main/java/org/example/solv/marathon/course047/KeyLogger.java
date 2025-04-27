package org.example.solv.marathon.course047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KeyLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            Deque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (cur == '<' && !left.isEmpty()) {
                    right.addFirst(left.pollLast());
                } else if (cur == '>' && !right.isEmpty()) {
                    left.addLast(right.pollFirst());
                } else if (cur == '-' && !left.isEmpty()) {
                    left.pollLast();
                } else if (cur != '>' && cur != '<' && cur != '-') {
                    left.addLast(cur);
                }
            }
            for (char c : left) {
                sb.append(c);
            }
            for (char c : right) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
