package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class HideAndSeek {

    static int target;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N));
    }

    private static int bfs(int n) {
        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[]{n, 0});
        while (true) {
            int[] cur = queue.poll();
            if (cur[0] < 0) continue;
            if (cur[0] == target) {
                return cur[1];
            } else if (cur[0] > 100000) {
            } else if (!visited[cur[0]]) {
                queue.add(new int[]{cur[0] + 1, cur[1] + 1});
                queue.add(new int[]{cur[0] - 1, cur[1] + 1});
                queue.add(new int[]{cur[0] * 2, cur[1] + 1});
                visited[cur[0]] = true;
            }
        }
    }

}
