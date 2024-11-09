package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.*;

public class EasyShortestDistance {

    static int[][] distance;
    static boolean[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        distance = new int[N][M];
        int x = -1, y = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n == 1;
                if (n == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x,y);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dist = distance[i][j];
                if (dist == 0 && arr[i][j] == true) {
                    dist = -1;
                }
                sb.append(dist).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (check(nx, ny)) {
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= distance.length || y < 0 || y >= distance[0].length || distance[x][y] > 0) return false;
        else return arr[x][y];
    }
}
