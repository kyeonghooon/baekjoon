package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class EasyShortestDistanceImprove {

    static int[] distance;
    static boolean[] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N * M];
        distance = new int[N * M];
        int startX = -1, startY = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    arr[i * M + j] = true;
                } else if (n == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY, N, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int pos = i * M + j;
                int dist = distance[pos];
                if (dist == 0 && arr[pos]) {
                    dist = -1;
                }
                sb.append(dist).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y, int N, int M) {
        int[] queue = new int[N * M];
        int head = 0, tail = 0;
        int startPos = x * M + y;
        queue[tail++] = startPos;
        distance[startPos] = 0;

        while (head < tail) {
            int pos = queue[head++];
            int curX = pos / M;
            int curY = pos % M;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nPos = nx * M + ny;
                    if (arr[nPos] && distance[nPos] == 0) {
                        distance[nPos] = distance[pos] + 1;
                        queue[tail++] = nPos;
                    }
                }
            }
        }
    }
}
