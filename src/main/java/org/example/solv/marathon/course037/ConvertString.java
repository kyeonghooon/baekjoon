package org.example.solv.marathon.course037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class ConvertString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int a = Integer.parseInt(splits[0]);
        int b = Integer.parseInt(splits[1]);
        splits = br.readLine().split(" ");
        int n = Integer.parseInt(splits[0]);
        int m = Integer.parseInt(splits[1]);
        boolean[][] lines = new boolean[n + 1][n + 1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        while (m-- > 0) {
            splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            lines[start][end] = lines[end][start] = true;
        }
        queue.add(new int[]{a, 0});
        visited[a] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            if (cur[0] == b) {
                System.out.println(cur[1]);
                return;
            } else {
                for (int i = 1; i <= n; i++) {
                    if (lines[cur[0]][i] && !visited[i]) {
                        queue.add(new int[]{i, cur[1] + 1});
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

}
