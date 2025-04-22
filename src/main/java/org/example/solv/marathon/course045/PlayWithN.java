package org.example.solv.marathon.course045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayWithN {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int remainder = 0;
        int count = 0;
        while (count++ <= N) {
            remainder = ((remainder * 10) + 1) % N;
            if (remainder == 0) {
                break;
            }
        }
        if (remainder != 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
