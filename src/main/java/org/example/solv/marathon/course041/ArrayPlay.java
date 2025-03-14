package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayPlay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[][] arr = new int[2][N + 1];
            for (int i = 1; i <= N; i++) {
                input = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    int n = Integer.parseInt(input[j - 1]);
                    arr[0][i] += n;
                    arr[1][j] += n;
                }
            }
            while (M-- > 0) {
                input = br.readLine().split(" ");
                int r1 = Integer.parseInt(input[0]);
                int c1 = Integer.parseInt(input[1]);
                int r2 = Integer.parseInt(input[2]);
                int c2 = Integer.parseInt(input[3]);
                int v = Integer.parseInt(input[4]);
                for (int i = r1; i <= r2; i++) {
                    arr[0][i] += v * (c2 - c1 + 1);
                }
                for (int i = c1; i <= c2; i++) {
                    arr[1][i] += v * (r2 - r1 + 1);
                }
            }
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                row.append(arr[0][i]).append(" ");
                col.append(arr[1][i]).append(" ");
            }
            sb.append(row.toString()).append("\n");
            sb.append(col.toString()).append("\n");
        }
        System.out.println(sb);
    }
}
