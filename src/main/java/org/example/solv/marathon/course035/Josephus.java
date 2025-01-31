package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Josephus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int n = Integer.parseInt(splits[0]);
        int k = Integer.parseInt(splits[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++, count++) {
            if (count % k == 0) {
                sb.append(i).append(", ");
            } else {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            if (count++ % k == 0) {
                sb.append(queue.pollFirst()).append(", ");
            } else {
                queue.addLast(queue.pollFirst());
            }
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.println(sb);
    }

}
