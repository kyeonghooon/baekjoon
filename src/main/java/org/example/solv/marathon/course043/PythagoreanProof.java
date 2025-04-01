package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythagoreanProof {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            long answer = N + (N / 2) * 2;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
