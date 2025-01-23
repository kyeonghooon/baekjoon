package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxGCD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            int[] list = new int[splits.length];
            for (int i = 0; i < splits.length; i++) {
                list[i] = Integer.parseInt(splits[i]);
            }
            int max = 0;
            for (int i = 0; i < list.length - 1; i++) {
                for (int j = i + 1; j < list.length; j++) {
                    max = Math.max(max, gcd(list[i], list[j]));
                }
            }
            System.out.println(max);
        }
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

}
