package org.example.solv.programmers.summer_winter.lv2;

public class VisitLength {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        final int U = 0;
        final int D = 1;
        final int R = 2;
        final int L = 3;
        for (char c : dirs.toCharArray()) {
            switch (c) {
                case 'U' :
                    if (y == 10) break;
                    if (!visited[y][x][U]) {
                        answer++;
                    }
                    visited[y][x][U] = true;
                    visited[++y][x][D] = true;
                    break;
                case 'D' :
                    if (y == 0) break;
                    if (!visited[y][x][D]) {
                        answer++;
                    }
                    visited[y][x][D] = true;
                    visited[--y][x][U] = true;
                    break;
                case 'R' :
                    if (x == 10) break;
                    if (!visited[y][x][R]) {
                        answer++;
                    }
                    visited[y][x][R] = true;
                    visited[y][++x][L] = true;
                    break;
                case 'L' :
                    if (x == 0) break;
                    if (!visited[y][x][L]) {
                        answer++;
                    }
                    visited[y][x][L] = true;
                    visited[y][--x][R] = true;
                    break;
            }
        }
        return answer;
    }
}
