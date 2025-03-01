package org.example.solv.marathon.course039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SurfaceArea {

    static int[][] matrix;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] split = br.readLine().split(" ");
            R = Integer.parseInt(split[0]);
            C = Integer.parseInt(split[1]);
            matrix = new int[R][C];
            int sum = 0;
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    int n = line.charAt(j) - '0';
                    matrix[i][j] = n;
                    sum += matrix[i][j];
                }
            }
            sum *= 6;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sum += check(i, j);
                }
            }
            System.out.println(sum);
        }
    }

    static int check(int i, int j) {
        int length = matrix[i][j];
        int ans = 0;
        for (int k = 1; k <= length; k++) {
            if (k > 1) ans -= 2;
            for (int l = 0; l < 4; l++) {
                int nI = i + dI[l];
                int nJ = j + dJ[l];
                if (nI >= 0 && nI < R && nJ >= 0 && nJ < C) {
                    if (matrix[nI][nJ] >= k) ans--;
                }
            }
        }
        return ans;
    }

    static int[] dI = new int[]{-1, 0, 1, 0};
    static int[] dJ = new int[]{0, 1, 0, -1};

}
