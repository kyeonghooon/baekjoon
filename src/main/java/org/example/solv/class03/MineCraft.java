package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MineCraft {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMB = br.readLine().split(" ");
        int N = Integer.parseInt(NMB[0]);
        int M = Integer.parseInt(NMB[1]);
        int B = Integer.parseInt(NMB[2]);
        int total = N * M;
        int[] frequency = new int[257];
        int sum = B;
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(line[j]);
                frequency[height]++;
                sum += height;
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }
        max = Math.min(max, sum / total);
        int resultTime = Integer.MAX_VALUE;
        int resultHeight = min;
        for (int i = min; i <= max; i++) {
            int add = 0;
            int remove = 0;
            for (int h = 0; h < i; h++) {
                add += (i - h) * frequency[h];
            }
            for (int h = i + 1; h <= max; h++) {
                remove += (h - i) * frequency[h];
            }
            if (remove + B >= add) {
                int time = add + (remove * 2);
                if (time <= resultTime) {
                    resultTime = time;
                    resultHeight = i;
                }
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}
