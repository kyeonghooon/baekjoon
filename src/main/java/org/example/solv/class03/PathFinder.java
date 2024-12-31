package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathFinder {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[][] result = new boolean[N][N];
        for (int start = 0; start < N; start++) {
            String[] splits = br.readLine().split(" ");
            for (int end = 0; end < N; end++) {
                result[start][end] = splits[end].equals("1");
            }
        }
        // Floyd-Warshall
        for (int mid = 0; mid < N; mid++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if (result[start][mid] && result[mid][end]) {
                        result[start][end] = true;
                    }
                }
            }
        }
        for (int start = 0; start < N; start++) {
            for (int end = 0; end < N; end++) {
                sb.append(result[start][end] ? "1" : "0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
