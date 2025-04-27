package org.example.solv.marathon.course047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LevelUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(binarySearch(N)).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n) {
        int level = 0;
        long experience = (long) n * (n + 1) / 2;
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long total = (long) mid * (mid - 1);
            if (total > experience) {
                right = mid - 1;
            } else {
                level = mid;
                left = mid + 1;
            }
        }
        return level;
    }
}
