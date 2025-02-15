package org.example.solv.marathon.course037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class King {

    static final int R = 0;
    static final int L = 1;
    static final int B = 2;
    static final int T = 3;
    static final int RT = 4;
    static final int LT = 5;
    static final int RB = 6;
    static final int LB = 7;

    static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static final int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int kingX = splits[0].charAt(0) - 'A';
        int kingY = splits[0].charAt(1) - '1';
        int stoneX = splits[1].charAt(0) - 'A';
        int stoneY = splits[1].charAt(1) - '1';
        int N = Integer.parseInt(splits[2]);
        for (int i = 0; i < N; i++) {
            String move = br.readLine();

            // 1. 명령어 확인
            int dir = getIndex(move);
            // 2. 이동 위치가 체스판을 벗어나는지 확인
            int kingNextX = kingX + dx[dir];
            int kingNextY = kingY + dy[dir];
            if (isOutOfChessBoard(kingNextX, kingNextY)) {
                continue;
            }
            // 3. 돌이 있는 경우 돌을 같은 방향으로 이동시켰을 때 돌이 체스판을 벗어나는지 확인 후 이동
            if (kingNextX == stoneX && kingNextY == stoneY) {
                int stoneNextX = stoneX + dx[dir];
                int stoneNextY = stoneY + dy[dir];
                if (isOutOfChessBoard(stoneNextX, stoneNextY)) {
                    continue;
                }
                stoneX = stoneNextX;
                stoneY = stoneNextY;
            }
            // 4. 이동
            kingX = kingNextX;
            kingY = kingNextY;
        }
        System.out.println((char) (kingX + 'A') + "" + (char) (kingY + '1'));
        System.out.println((char) (stoneX + 'A') + "" + (char) (stoneY + '1'));
    }

    static int getIndex(String move) {
        switch (move) {
            case "R":
                return R;
            case "L":
                return L;
            case "B":
                return B;
            case "T":
                return T;
            case "RT":
                return RT;
            case "LT":
                return LT;
            case "RB":
                return RB;
            case "LB":
                return LB;
        }
        return -1;
    }

    static boolean isOutOfChessBoard(int x, int y) {
        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }
}
