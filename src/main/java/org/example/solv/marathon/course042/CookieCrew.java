package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookieCrew {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int X = 0;
        final int Y = 1;
        int[] start = new int[2];
        int[] end = new int[2];
        int[][] J = new int[3][2];
        int[][] C = new int[3][2];
        int[][] B = new int[3][2];
        int[][] W = new int[3][2];
        int[] index = new int[4];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case 'H':
                        start[X] = j;
                        start[Y] = i;
                        break;
                    case 'J':
                        J[index[0]][X] = j;
                        J[index[0]++][Y] = i;
                        break;
                    case 'C':
                        C[index[1]][X] = j;
                        C[index[1]++][Y] = i;
                        break;
                    case 'B':
                        B[index[2]][X] = j;
                        B[index[2]++][Y] = i;
                        break;
                    case 'W':
                        W[index[3]][X] = j;
                        W[index[3]++][Y] = i;
                        break;
                    case '#':
                        end[X] = j;
                        end[Y] = i;
                        break;
                }
            }
        }
        int[][] permutation = new int[][]{
                {1, 2, 0},
                {1, 0, 2},
                {2, 1, 0},
                {2, 0, 1},
                {0, 1, 2},
                {0, 2, 1}
        };
        int[][][] arr = new int[4][3][2];
        arr[0] = J;
        arr[1] = C;
        arr[2] = B;
        arr[3] = W;
        int min = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                int curDistance = 0;
                for (int k = 0; k < 3; k++) {
                    if (k == 0) {
                        curDistance += distance(arr[i][permutation[j][k]], start);
                    } else {
                        curDistance += distance(arr[i][permutation[j][k]], arr[i][permutation[j][k - 1]]);
                    }
                }
                curDistance += distance(arr[i][permutation[j][2]], end);
                if (curDistance < min) {
                    min = curDistance;
                    answer = i;
                }
            }
        }
        String ansStr = "";
        switch (answer) {
            case 0:
                ansStr = "Assassin";
                break;
            case 1:
                ansStr = "Healer";
                break;
            case 2:
                ansStr = "Mage";
                break;
            case 3:
                ansStr = "Tanker";
                break;
        }
        System.out.println(ansStr);
    }

    static int distance(int[] start, int[] end) {
        return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
    }
}
