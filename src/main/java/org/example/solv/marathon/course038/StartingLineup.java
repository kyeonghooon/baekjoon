package org.example.solv.marathon.course038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartingLineup {

    static int[][] arr;
    static int maxSum;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] split = null;
            maxSum = 0;
            arr = new int[11][11];
            used = new boolean[11];
            for (int i = 0; i < 11; i++) {
                split = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(split[j]);
                }
            }
            backTrack(0, 0);
            System.out.println(maxSum);
        }
    }

    static void backTrack(int player, int curSum) {
        if (player == 11) {
            maxSum = Math.max(maxSum, curSum);
        } else {
            for (int position = 0; position < 11; position++) {
                if (!used[position] && arr[player][position] > 0) {
                    used[position] = true;
                    backTrack(player + 1, curSum + arr[player][position]);
                    used[position] = false;
                }
            }
        }
    }

}
