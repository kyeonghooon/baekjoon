package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Laveling {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) == '1';
            }
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int totalCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] && !visited[i][j]) {
                    totalCount++;
                    int personalCount = 1;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] && !visited[nx][ny]) {
                                queue.add(new int[]{nx, ny});
                                personalCount++;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    list.add(personalCount);
                }
            }
        }
        Collections.sort(list);
        sb.append(totalCount).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

}
