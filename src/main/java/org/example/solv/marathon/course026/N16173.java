package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16173 {

    static int[][] arr;
    static boolean victory = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        if (!victory) System.out.println("Hing");
    }

    public static void dfs(int i, int j) {
        if (arr[i][j] == -1) {
            System.out.println("HaruHaru");
            victory = true;
        } else {
            int n = arr[i][j];
            if (n == 0) {
                return;
            }
            if (!(n + j >= arr.length)) {
                dfs(i, j + n);
            }
            if (!(n + i >= arr.length)) {
                dfs(i + n, j);
            }
        }
    }

}
