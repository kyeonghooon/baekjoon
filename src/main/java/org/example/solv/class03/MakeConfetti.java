package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeConfetti {

    static int white;
    static int blue;
    static boolean[][] check;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1][n + 1];
        // 초기화
        for (int i = 1; i <= n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                check[i][j] = row[(j - 1) * 2] == '1';
            }
        }
        // 로직
        dfs(1, n + 1, 1, n + 1);
        sb.append(white).append("\n").append(blue);
        System.out.print(sb);
    }

    static void dfs(int x1, int x2, int y1, int y2) {
        boolean cur = check[x1][y1];
        boolean flag = true;
        for (int i = x1; i < x2; i++) {
            if (!flag) break;
            for (int j = y1; j < y2; j++) {
                if (check[i][j] != cur) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            if (cur) {
                blue++;
            } else {
                white++;
            }
        } else {
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            dfs(x1, midX, y1, midY);
            dfs(midX, x2, y1, midY);
            dfs(x1, midX, midY, y2);
            dfs(midX, x2, midY, y2);
        }
    }

}
