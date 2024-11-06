package org.example.solv.marathon.course022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[26][2];
        int[] row = new int[6];
        int[] col = new int[6];
        int[] diagonal = new int[2];
        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                board[number][0] = i;
                board[number][1] = j;
            }
        }
        int[] nums = new int[26];
        int index = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }
        int count = 0;
        for (int k = 1; k < 26; k++) {
            int n = nums[k];
            int i = board[n][0];
            int j = board[n][1];
            row[i]++;
            col[j]++;
            if (i == j) {
                diagonal[0]++;
                if (diagonal[0] == 5) count++;
            }
            if (i + j == 6) {
                diagonal[1]++;
                if (diagonal[1] == 5) count++;
            }
            if (row[i] == 5) count++;
            if (col[j] == 5) count++;


            if (count > 2) {
                System.out.println(k);
                break;
            }
        }
    }

}
