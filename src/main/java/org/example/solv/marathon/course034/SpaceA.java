package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpaceA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] arr = new int[3]; // 0: R, 1: U, 2: X
        final int R = 0, U = 1, X = 2;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'R':
                    arr[R]++;
                    break;
                case 'U':
                    arr[U]++;
                    break;
                case 'X':
                    arr[X]++;
                    break;
            }
        }
        int k = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < k; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int dx = x - 1;
            int dy = y - 1;
            int maxT = Math.min(Math.min(dx, dy), arr[X]);
            int minT = Math.max(dx - arr[R], dy - arr[U]);
            if (minT <= maxT) {
                count++;
            }
        }
        System.out.println(count);
    }

}
