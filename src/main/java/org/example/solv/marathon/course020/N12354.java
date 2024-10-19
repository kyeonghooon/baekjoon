package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N12354 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                queue.addLast(a);
            }
            int count = Math.min(lowStack(new ArrayDeque<>(queue)), highStack(new ArrayDeque<>(queue)));
            sb.append("Case #").append(i + 1).append(": ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int lowStack(Deque<Integer> queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.removeLast();
            while (!queue.isEmpty() && cur <= queue.peekLast()) {
                queue.removeLast();
                count++;
            }
        }
        return count;
    }
    private static int highStack(Deque<Integer> queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            while (!queue.isEmpty() && cur >= queue.peekFirst()) {
                queue.removeFirst();
                count++;
            }
        }
        return count;
    }
}
