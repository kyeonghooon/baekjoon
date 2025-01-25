package org.example.solv.class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM2 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            StringBuilder curSb = new StringBuilder();
            curSb.append(i).append(" ");
            visited[i] = true;
            bfs(i, 0, curSb);
        }
        System.out.println(sb);
    }

    public static void bfs(int n, int index, StringBuilder curSb) {
        index++;
        if (index == M) {
            sb.append(curSb).append("\n");
        } else {
            for (int i = n + 1; i <= N; i++) {
                StringBuilder curSb2 = new StringBuilder();
                curSb2.append(curSb).append(i).append(" ");
                visited[i] = true;
                bfs(i, index, curSb2);
                visited[i] = false;
            }
        }

    }

}
