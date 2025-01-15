package org.example.solv.class03;

import java.io.IOException;

public class Tetromino {

    static int N;
    static int M;
    static int[][] field;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = readInt();
        M = readInt();
        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = readInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int max = getMax(i, j);
                answer = Math.max(answer, max);
            }
        }
        System.out.println(answer);
    }

    private static int getMax(int i, int j) {
        int max = 0;
        for (int k = 0; k < tetrominoShapes.length; k++) {
            boolean flag = true;
            int cur = 0;
            for (int l = 0; l < 4; l++) {
                int[] coord = validCoord(tetrominoShapes[k][l], i, j);
                if (coord.length == 0) {
                    flag = false;
                    continue;
                }
                cur += field[coord[Y]][coord[X]];
            }
            if (!flag) continue;
            max = Math.max(max, cur);
        }
        return max;
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

    private static int[] validCoord(int[] coord, int y, int x) {
        int ny = coord[Y] + y;
        int nx = coord[X] + x;
        if (ny > -1 && nx > -1 && ny < N && nx < M) {
            return new int[]{ny, nx};
        } else {
            return new int[]{};
        }
    }

    private static int[][][] tetrominoShapes = {
            // ㅡ , ㅣ
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            // ㅁ
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            // L
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 0}, {1, 1}, {1, 2}},

            // J
            {{0, 1}, {1, 1}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},

            // S
            {{0, 1}, {0, 2}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},

            // Z
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 0}, {1, 1}, {2, 0}},

            // ㅏ ㅓ ㅗ ㅜ
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 1}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},

    };
    static final int Y = 0;
    static final int X = 1;
}
