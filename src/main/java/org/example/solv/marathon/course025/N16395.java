package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16395 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] pascal = new int[n + 1][n + 1];
        dp(pascal);
        System.out.println(pascal[n][k]);
    }

    public static void dp(int[][] pascal) {
        for (int i = 1; i < pascal.length; i++) {
            for (int j = 1; j < pascal[i].length; j++) {
                if (j == 1 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }
    }

}
