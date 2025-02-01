package org.example.solv.programmers.dfs_bfs.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameMap {

    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};
        int n = maps[0].length;
        int m = maps.length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0, 1});
        maps[0][0] = 0;
        while (!queue.isEmpty() && answer == -1) {
            int[] cur = queue.pollFirst();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[ny][nx] == 1) {
                    if (nx == n - 1 && ny == m - 1) {
                        answer = cur[2] + 1;
                        break;
                    }
                    queue.addLast(new int[]{nx, ny, cur[2] + 1});
                    maps[ny][nx] = 0;
                }
            }
        }
        return answer;
    }

}
