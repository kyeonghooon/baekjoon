package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10157 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        boolean[][] visit = new boolean[R][C];

        int count = 0;
        int x = R - 1;
        int y = 0;
        int direction = 0;
        while (++count != K) {
            visit[x][y] = true;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny]) {
                direction = ++direction % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }
        System.out.println((y + 1) + " " + (R - x));
    }

}
