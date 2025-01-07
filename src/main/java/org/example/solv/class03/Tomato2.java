package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Tomato2 {

    static int[] dh = {-1,0,0,0,0,1};
    static int[] dn = {0,-1,1,0,0,0};
    static int[] dm = {0,0,0,-1,1,0};
    static int H;
    static int N;
    static int M;
    static int[][][] boxes;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        M = Integer.parseInt(splits[0]);
        N = Integer.parseInt(splits[1]);
        H = Integer.parseInt(splits[2]);
        int total = M * N * H;
        boxes = new int[H][N][M];
        int zeroCount = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int finalDay = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                splits = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int state = Integer.parseInt(splits[k]);
                    boxes[i][j][k] = state;
                    switch (state) {
                        case 0:
                            zeroCount++;
                            break;
                        case 1:
                            queue.addLast(new int[]{i, j, k, 0});
                            break;
                    }
                }
            }
        }
        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int h = cur[0];
            int n = cur[1];
            int m = cur[2];
            int curDay = cur[3];
            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nn = n + dn[i];
                int nm = m + dm[i];
                if (check(nh, nn, nm)) {
                    boxes[nh][nn][nm] = 1;
                    zeroCount--;
                    queue.addLast(new int[]{nh, nn, nm, curDay + 1});
                    finalDay = Math.max(finalDay, curDay + 1);
                }
            }
        }
        if (zeroCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(finalDay);
        }
    }

    static boolean check(int nh, int nn, int nm) {
        if (nh < 0 || nn < 0 || nm < 0) return false;
        if (nh >= H || nn >= N || nm >= M) return false;
        return boxes[nh][nn][nm] == 0;
    }
}
