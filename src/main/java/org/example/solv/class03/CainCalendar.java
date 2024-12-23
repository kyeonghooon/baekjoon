package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CainCalendar {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            boolean found = false;
            for (int i = 0; i <= N; i++) {
                int num = M * i + x;
                if (num > M * N) break;
                if (num % N == y % N) {
                    found = true;
                    System.out.println(num);
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }
        }
    }

}
