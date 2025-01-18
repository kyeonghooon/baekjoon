package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DucciSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] splits = br.readLine().split(" ");
            int[] arr = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            while (count++ < 1000) {
                int zeroCount = 0;
                int[] prev = Arrays.copyOf(arr, n);
                for (int i = 0; i < n; i++) {
                    arr[i] = Math.abs(prev[i] - prev[(i + 1) % n]);
                    if (arr[i] == 0) zeroCount++;
                }
                if (zeroCount == n) break;
            }
            if (count < 1000) sb.append("ZERO").append("\n");
            else sb.append("LOOP").append("\n");
        }
        System.out.println(sb);
    }

}
