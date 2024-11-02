package org.example.solv.marathon.course022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N31714 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] seats = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] line = new int[M];
            for (int j = 0; j < M; j++) {
                line[j] = Integer.parseInt(st.nextToken()) + i * D;
            }
            Arrays.sort(line);
            seats[i] = line;
            if (i != 0) {
                for (int j = 0; j < M; j++) {
                    if (seats[i - 1][j] >= seats[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }

}
