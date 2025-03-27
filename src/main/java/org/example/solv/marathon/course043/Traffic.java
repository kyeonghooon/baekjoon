package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traffic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            String[] left = br.readLine().split(" ");
            String[] right = br.readLine().split(" ");
            int count = 0;
            for (int i = 0; i < m; i += 2) {
                int x = Integer.parseInt(left[i]);
                int y = Integer.parseInt(right[i]);
                if (x < y) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
