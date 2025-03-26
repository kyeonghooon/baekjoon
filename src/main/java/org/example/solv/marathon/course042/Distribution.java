package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distribution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int max = (int) Math.pow(2, N) - 1;
        int halfMax = max / 2;
        int size = (int) Math.pow(2, N - K);
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int count = 0;
        while (cur <= halfMax) {
            if (count == size) {
                sb.append("\n");
                count = 0;
            }
            sb.append(cur).append(" ").append(max - cur).append(" ");
            count += 2;
            cur++;
        }
        System.out.println(sb);
    }
}
