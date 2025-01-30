package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        String[] splits = null;
        for (int i = 1; i <= n; i++) {
            splits = br.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);
            int w = Integer.parseInt(splits[2]);
            int h = Integer.parseInt(splits[3]);
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    arr[y + j][x + k] = i;
                }
            }
        }
        int[] result = new int[n + 1];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                result[arr[i][j]]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

}
