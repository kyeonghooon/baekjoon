package org.example.solv.class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM4 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] store;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        store = new int[M];
        permutation(0, 1);
        System.out.println(sb);
    }

    public static void permutation(int count, int start) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(store[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= N; i++) {
                store[count] = i;
                permutation(count + 1, i);
            }
        }
    }

}
