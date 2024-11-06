package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_dp {

    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = (int) Math.pow(2, N);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[m][m];
        dp(0, 0, m - 1, m - 1);
        System.out.println(arr[r][c]);
    }

    static void dp(int startRow, int startCol, int endRow, int endCol) {
        int rowLen = endRow - startRow;
        int colLen = endCol - startCol;
        if (rowLen == 1 && colLen == 1) {
            arr[startRow][startCol] = count++;
            arr[startRow][endCol] = count++;
            arr[endRow][startCol] = count++;
            arr[endRow][endCol] = count++;
        } else {
            dp(startRow, startCol, startRow + rowLen / 2, startCol + colLen / 2);
            dp(startRow, startCol + colLen / 2 + 1, startRow + rowLen / 2, endCol);
            dp(startRow + rowLen / 2 + 1, startCol, endRow, startCol + colLen / 2);
            dp(startRow + rowLen / 2 + 1, startCol + colLen / 2 + 1, endRow, endCol);
        }
    }

}
