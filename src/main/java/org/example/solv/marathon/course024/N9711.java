package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int P = Integer.parseInt(split[0]);
            long Q = Integer.parseInt(split[1]);
            sb.append("Case #").append(i + 1).append(": ").append(fibonacci(P, Q)).append("\n");
        }
        System.out.println(sb);
    }

    public static long fibonacci(int P, long Q) {
        if (P == 1 || P == 2) {
            return 1 % Q;
        } else {
            long a = 1, b = 1;
            for (int i = 3; i <= P; i++) {
                long temp = a;
                a = b;
                b = (temp + b) % Q;
            }
            return b;
        }
    }

}
