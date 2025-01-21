package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Banner {

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int M, N;
    static boolean[][] banner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        banner = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                banner[i][j] = split[j].equals("1");
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (banner[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int y, int x) {
        banner[y][x] = false;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && ny > -1 && nx < N && ny < M && banner[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

}
