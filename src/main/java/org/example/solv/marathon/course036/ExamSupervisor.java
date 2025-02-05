package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExamSupervisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = N;
        String[] splits = br.readLine().split(" ");
        String[] splits2 = br.readLine().split(" ");
        int B = Integer.parseInt(splits2[0]);
        int C = Integer.parseInt(splits2[1]);
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(splits[i]) - B;
            if (A < 0) A = 0;
            sum += (A + C - 1) / C;
        }
        System.out.println(sum);
    }

}
