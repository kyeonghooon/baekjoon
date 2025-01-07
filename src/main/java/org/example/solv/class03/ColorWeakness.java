package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ColorWeakness {

    static int N;
    static char[][] field;
    static boolean[][] visitedNormal;
    static boolean[][] visitedColorWeakness;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new char[N][N];
        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
        }
        visitedNormal = new boolean[N][N];
        visitedColorWeakness = new boolean[N][N];
        int countNormal = 0;
        int countColorWeakness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    countNormal++;
                    dfsNormal(i, j, field[i][j]);
                }
                if (!visitedColorWeakness[i][j]) {
                    countColorWeakness++;
                    dfsColorWeakness(i, j, field[i][j]);
                }
            }
        }
        System.out.println(countNormal + " " + countColorWeakness);
    }

    static void dfsNormal(int x, int y, char c) {
        visitedNormal[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (validCoord(nx, ny) && !visitedNormal[nx][ny] && c == field[nx][ny]) {
                dfsNormal(nx, ny, c);
            }
        }
    }

    static void dfsColorWeakness(int x, int y, char c) {
        visitedColorWeakness[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (validCoord(nx, ny) && !visitedColorWeakness[nx][ny] && checkForColorWeakness(nx, ny, c)) {
                dfsColorWeakness(nx, ny, c);
            }
        }
    }

    static boolean validCoord(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static boolean checkForColorWeakness(int x, int y, char c) {
        if (c == 'B') return field[x][y] == 'B';
        else return field[x][y] != 'B';
    }
}