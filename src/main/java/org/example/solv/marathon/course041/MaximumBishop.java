package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumBishop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int add = Math.max(0, N - 2);
        int ans = N + add;
        sb.append(ans).append("\n");
        for (int i = 1; i <= N; i++) {
            sb.append(1).append(" ").append(i).append("\n");
        }
        for (int i = 2; i <= N - 1; i++) {
            sb.append(N).append(" ").append(i).append("\n");
        }
        System.out.println(sb);
    }
}
