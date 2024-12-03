package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2799 {

    static int[] result;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new char[M * 5 + 1][N * 5 + 1];
        for (int i = 0; i < arr.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        result = new int[5];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count(i,j);
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void count(int i, int j) {
        int sum = 0;
        i = i * 5 + 1;
        j = j * 5 + 1;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                sum += arr[i + k][j + l];
            }
        }
        switch (sum) {
            case 736:
                result[0]++;
                break;
            case 720:
                result[1]++;
                break;
            case 704:
                result[2]++;
                break;
            case 688:
                result[3]++;
                break;
            case 672:
                result[4]++;
                break;
        }
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{i, j});
    }

}
