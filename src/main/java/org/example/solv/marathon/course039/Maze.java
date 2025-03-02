package org.example.solv.marathon.course039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Maze {

    static final int[] dx = new int[]{0, -1, 0, 1};
    static final int[] dy = new int[]{-1, 0, 1, 0};
    static int state;
    static int x;
    static int y;
    static Set<String> set = new HashSet<>();
    static int minX, minY, maxX, maxY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        state = 0;
        x = minX = maxX = 0;
        y = minY = maxY = 0;
        set.add(x + "_" + y);
        for (int i = 0; i < n; i++) {
            move(str.charAt(i));
        }
        for (int i = maxY; i >= minY; i--) {
            for (int j = minX; j <= maxX; j++) {
                sb.append(set.contains(j + "_" + i) ? '.' : '#');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void move(char c) {
        switch (c) {
            case 'R':
                state = (state + 1) % 4;
                break;
            case 'L':
                state = (state + 3) % 4;
                break;
            default:
                x += dx[state];
                y += dy[state];
                set.add(x + "_" + y);
                setXY(x, y);
                break;
        }
    }

    static void setXY(int x, int y) {
        minX = Math.min(x, minX);
        maxX = Math.max(x, maxX);
        minY = Math.min(y, minY);
        maxY = Math.max(y, maxY);
    }

}
