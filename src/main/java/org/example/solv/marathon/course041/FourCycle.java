package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FourCycle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_007;
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[][] nodes = new boolean[N + 1][N + 1];
        ArrayList<Pair> Edge = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Edge.add(new Pair(x, y));
            nodes[x][y] = nodes[y][x] = true;
        }
        long answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                int x1 = Edge.get(i).x, y1 = Edge.get(i).y, x2 = Edge.get(j).x, y2 = Edge.get(j).y;
                if (x1 == x2 || x1 == y2 || y1 == x2 || y1 == y2)
                    continue;
                if (nodes[x1][x2] && nodes[y1][y2])
                    answer++;
                if (nodes[x1][y2] && nodes[y1][x2])
                    answer++;
            }
        }
        System.out.println(answer * 500_000_004 % MOD);
    }

}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
