package org.example.solv.marathon.course048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CityAndBitCoin {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j += 2) {
                arr[i][j / 2] = str.charAt(j) == '1';
            }
        }
        System.out.println(bfs(arr) ? "Yes" : "No");
    }

    private static boolean bfs(boolean[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[0];

            if (y == M - 1 && x == N - 1) {
                return true;
            }

            for (int d = 0; d < 2; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny >= M || nx >= N) continue;
                if (visited[ny][nx] || !arr[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
        return false;
    }
}
