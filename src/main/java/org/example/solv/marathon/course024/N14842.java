package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14842 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        double sum;
        if (N % 2 == 0) {
            // N이 짝수인 경우
            sum = (N / 2.0) - 1.0;
        } else {
            // N이 홀수인 경우
            sum = ((double)(N - 1) * (double)(N - 1)) / (2.0 * (double)N);
        }
        double result = H * sum;
        System.out.printf("%.6f", result);
    }

}
