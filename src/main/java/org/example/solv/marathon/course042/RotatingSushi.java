package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RotatingSushi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                int sushi = Integer.parseInt(input[j]);
                Deque<Integer> deque = map.getOrDefault(sushi, new ArrayDeque<>());
                deque.addLast(i);
                map.put(sushi, deque);
            }
        }
        input = br.readLine().split(" ");
        int[] answer = new int[N];
        for (int i = 0; i < M; i++) {
            int sushi = Integer.parseInt(input[i]);
            if (map.containsKey(sushi) && !map.get(sushi).isEmpty()) {
                answer[map.get(sushi).pollFirst()]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
