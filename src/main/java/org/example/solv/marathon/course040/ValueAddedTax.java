package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValueAddedTax {

    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            X = Integer.parseInt(split[1]);
            long intPart = 0;
            long fracPart = 0;
            while (N-- > 0) {
                split = br.readLine().split("\\.");
                intPart += Integer.parseInt(split[0]);
                fracPart += Integer.parseInt(split[1]);
                intPart += fracPart / 100;
                fracPart %= 100;
            }
            int minF = find(intPart, fracPart, true);
            int maxF = find(intPart, fracPart, false);
            sb.append(minF).append(" ").append(maxF).append("\n");
        }
        System.out.println(sb);
    }

    static int find(long intPart, long fracPart, boolean type) {
        int minF = -1;
        int left = 0, right = 10000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long part0 = intPart, part1 = fracPart, part2 = 0;
            boolean up = false;
            part1 += intPart * mid;
            part2 += fracPart * mid;
            part1 += part2 / 100;
            part2 = part2 % 100;
            part0 += part1 / 100;
            part1 = part1 % 100;
            if (part1 == 99 && part2 > 0) up = true;
            if (part0 == X || up && part0 + 1 == X) {
                minF = mid;
                if (type) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (part0 > X) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minF;
    }

}
