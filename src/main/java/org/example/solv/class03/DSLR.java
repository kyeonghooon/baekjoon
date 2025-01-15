package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DSLR {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            int[] prev = new int[10000];
            boolean[] visited = new boolean[10000];
            char[] operation = new char[10000];
            prev[start] = -1;
            visited[start] = true;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addLast(start);
            while(!queue.isEmpty()) {
                int cur = queue.pollFirst();
                if (cur == end) break;
                int d = cur * 2 % 10000;
                if (!visited[d]) {
                    prev[d] = cur;
                    operation[d] = 'D';
                    visited[d] = true;
                    queue.add(d);
                }
                int s = cur == 0 ? 9999 : cur - 1;
                if (!visited[s]) {
                    prev[s] = cur;
                    operation[s] = 'S';
                    visited[s] = true;
                    queue.add(s);
                }
                int l = (cur / 1000) + (cur * 10 % 10000);
                if (!visited[l]) {
                    prev[l] = cur;
                    operation[l] = 'L';
                    visited[l] = true;
                    queue.add(l);
                }
                int r = cur / 10 + (cur % 10 * 1000);
                if (!visited[r]) {
                    prev[r] = cur;
                    operation[r] = 'R';
                    visited[r] = true;
                    queue.add(r);
                }
            }
            StringBuilder sequence = new StringBuilder();
            while (prev[end] != -1) {
                sequence.append(operation[end]);
                end = prev[end];
            }
            sb.append(sequence.reverse()).append("\n");
        }
        System.out.println(sb);
    }

}
