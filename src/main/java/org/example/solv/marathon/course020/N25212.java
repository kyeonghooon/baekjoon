package org.example.solv.marathon.course020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25212 {

    static int count = 0;
    static double[] cakes;
    static boolean[] selected;
    static int bound;
    static double total;
    static int ans;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cakes = new double[n];
        selected = new boolean[n];
        for (int i = 0; i < n; i++) {
            cakes[i] = Double.parseDouble(st.nextToken());
        }
        for (bound = 1; bound <= n; bound++) {
            DFS(0, 0);
        }
        System.out.println(ans);
    }
    public static void DFS(int idx, int cnt) {
        if (cnt == bound) {
            check();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            DFS(i, cnt + 1);
            selected[i] = false;
        }

    }
    public static void check() {
        total = 0;
        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                total += (1 / cakes[i]);
            }
        }
        if (total >= 0.99 && total <= 1.01) {
            ans++;
        }
    }

}
