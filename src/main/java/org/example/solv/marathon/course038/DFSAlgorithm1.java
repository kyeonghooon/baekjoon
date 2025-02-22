package org.example.solv.marathon.course038;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DFSAlgorithm1 {

    static ArrayList<Integer>[] lines;
    static int[] answer;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int R = readInt();
        lines = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }
        answer = new int[N + 1];
        while(M-- > 0) {
            int a = readInt();
            int b = readInt();
            lines[a].add(b);
            lines[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(lines[i]);
        }
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x) {
        answer[x] = count++;
        for(int i : lines[x]) {
            if (answer[i] == 0) dfs(i);
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
