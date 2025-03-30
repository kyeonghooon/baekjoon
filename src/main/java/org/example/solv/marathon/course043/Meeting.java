package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Meeting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];
        int[] b = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[] diff = new int[T + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int L = Math.max(a[c], a[d]);
            int R = Math.min(b[c], b[d]);
            if (L < R) {
                diff[L]++;
                diff[R]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int t = 0; t < T; t++) {
            cur += diff[t];
            sb.append(cur).append("\n");
        }
        System.out.println(sb);
    }
}
