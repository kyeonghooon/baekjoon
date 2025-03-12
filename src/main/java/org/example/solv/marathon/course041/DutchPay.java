package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DutchPay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[][] se = new int[N][2];
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            se[i][0] = Integer.parseInt(split[0]);
            se[i][1] = Integer.parseInt(split[1]);
        }
        double total = 0;
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int time = Integer.parseInt(split[0]);
            int price = Integer.parseInt(split[1]);
            boolean check = false;
            for (int j = 0; j < N; j++) {
                if (se[j][0] <= time && se[j][1] >= time) {
                    check = true;
                    break;
                }
            }
            if (check) {
                total += price;
            }
        }
        System.out.printf("%.5f", total / N);
    }
}
