package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class NeedFriends {

    static char[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dN = {-1, 1, 0, 0};
    static int[] dM = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];
        int startN = 0;
        int startM = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (s.charAt(j) == 'I') {
                    startN = i;
                    startM = j;
                } else if (s.charAt(j) == 'X') {
                    visited[i][j] = true;
                }
            }
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startN, startM});
        visited[startN][startM] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (arr[cur[0]][cur[1]] == 'P') count++;
            for (int i = 0; i < 4; i++) {
                int nextN = cur[0] + dN[i];
                int nextM = cur[1] + dM[i];
                if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && !visited[nextN][nextM]) {
                    visited[nextN][nextM] = true;
                    queue.add(new int[]{nextN, nextM});
                }
            }
        }
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("TT");
        }
    }

}
