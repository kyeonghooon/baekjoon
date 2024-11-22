package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tomato {

    static int[] date;
    static int maxDate;
    static int remain;
    static int[] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        tomato = new int[N * M];
        date = new int[N * M];
        maxDate = 0;
        remain = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                tomato[i * M + j] = n;
                if (n == 0) {
                    remain++;
                }
            }
        }
        bfs(N, M);
        if (remain > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDate);
        }
    }

    static void bfs(int N, int M) {
        int[] queue = new int[N * M];
        int head = 0, tail = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int pos = i * M + j;
                if (tomato[i * M + j] == 1) {
                    queue[tail++] = pos;
                    date[pos] = 0;
                }
            }
        }
        while (head < tail) {
            int pos = queue[head++];
            int curX = pos / M;
            int curY = pos % M;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nPos = nx * M + ny;
                    if (tomato[nPos] == 0) {
                        tomato[nPos] = 1;
                        remain--;
                        date[nPos] = date[pos] + 1;
                        maxDate = Math.max(maxDate, date[nPos]);
                        queue[tail++] = nPos;
                    }
                }
            }
        }
    }
}
