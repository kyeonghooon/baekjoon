package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class SnakesAndLadders {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);
        int[] snakesAndLadders = new int[101];
        boolean[] visited = new boolean[101];
        for (int i = 0; i < N + M; i++) {
            splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            snakesAndLadders[start] = end;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        int answer = 0;
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for (int i = 1; i <= 6; i++) {
                if (cur[0] + i >= 100) {
                    answer = cur[1] + 1;
                    queue.clear();
                    break;
                }
                int next = snakesAndLadders[cur[0] + i] > 0 ? snakesAndLadders[cur[0] + i] : cur[0] + i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        System.out.println(answer);
    }

}
