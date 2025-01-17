package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PythagorasExpectation {

    public static final int PLUS = 0;
    public static final int MINUS = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            int n = Integer.parseInt(splits[0]);
            int m = Integer.parseInt(splits[1]);
            int[][] result = new int[n + 1][2];
            while (m-- > 0) {
                splits = br.readLine().split(" ");
                int a = Integer.parseInt(splits[0]);
                int b = Integer.parseInt(splits[1]);
                int scoreA = Integer.parseInt(splits[2]);
                int scoreB = Integer.parseInt(splits[3]);
                result[a][PLUS] += scoreA;
                result[b][MINUS] += scoreA;
                result[b][PLUS] += scoreB;
                result[a][MINUS] += scoreB;
            }
            int max, min;
            min = max = calculate(result[1][PLUS], result[1][MINUS]);
            for (int i = 2; i <= n; i++) {
                min = Math.min(min, calculate(result[i][PLUS], result[i][MINUS]));
                max = Math.max(max, calculate(result[i][PLUS], result[i][MINUS]));
            }
            System.out.println(max);
            System.out.println(min);
        }
    }

    public static int calculate(int plus, int minus) {
        if (plus == 0 && minus == 0) return 0;
        double result = (plus * plus / (double)(plus * plus + minus * minus)) * 1000;
        return (int) result;
    }

}
