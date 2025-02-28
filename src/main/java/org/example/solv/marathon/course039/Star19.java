package org.example.solv.marathon.course039;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Star19 {

    public static void main(String[] args) throws IOException {
        int a = readInt();
        StringBuilder sb = new StringBuilder();
        int size = a * 4 - 3;
        char[][] arr = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(arr[i], ' ');
        }
        fill(arr, 0, 0, a);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void fill(char[][] arr, int x, int y, int n) {
        if (n == 0) return;
        int size = n * 4 - 3;
        for (int i = y; i < y + size; i++) {
            arr[x][i] = '*';
            arr[x + size - 1][i] = '*';
            arr[i][y] = '*';
            arr[i][y + size - 1] = '*';
        }
        fill(arr, x + 2, y + 2, n - 1);
    }

//    public static void main(String[] args) throws IOException {
//        int a = readInt();
//        StringBuilder sb = new StringBuilder();
//        int size = a * 4 - 3;
//        int[][] arr = new int[size][size];
//        int start = size / 2;
//        bfs(arr, start);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                sb.append(arr[i][j] == 1 ? '*' : ' ');
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    private static void bfs(int[][] arr, int start) {
        int size = arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        arr[start][start] = 1;
        deque.add(size * start + start);
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int x = cur / size;
            int y = cur % size;
            for (int i = 0; i < dy.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < size && ny >= 0 && ny < size && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] * -1;
                    deque.add(size * nx + ny);
                }
            }
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
