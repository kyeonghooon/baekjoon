package org.example.solv.class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NM5 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] store;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        store = new int[M];
        arr = new int[N];
        visited = new boolean[N];
        splits = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        Arrays.sort(arr);
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(store[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                store[count] = arr[i];
                visited[i] = true;
                permutation(count + 1);
                visited[i] = false;
            }
        }
    }

}
