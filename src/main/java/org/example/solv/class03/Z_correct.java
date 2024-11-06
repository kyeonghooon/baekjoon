package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_correct {

    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = (int) Math.pow(2, N);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(find(0,0, m, r, c));;
    }

    static int find(int startRow, int startCol, int size, int targetRow, int targetCol) {
        if (size == 1) {
            return count;
        }
        int newSize = size / 2;
        int areaCount = newSize * newSize;

        // 1번 사분면
        if (targetRow < startRow + newSize && targetCol < startCol + newSize) {
            return find(startRow, startCol, newSize, targetRow, targetCol);
        }
        // 2번 사분면
        else if (targetRow < startRow + newSize && targetCol >= startCol + newSize) {
            count += areaCount;
            return find(startRow, startCol + newSize, newSize, targetRow, targetCol);
        }
        // 3번 사분면
        else if (targetRow >= startRow + newSize && targetCol < startCol + newSize) {
            count += 2 * areaCount;
            return find(startRow + newSize, startCol,newSize, targetRow, targetCol);
        }
        // 4번 사분면
        else {
            count += 3 * areaCount;
            return find(startRow + newSize, startCol + newSize, newSize, targetRow, targetCol);
        }
    }

}
