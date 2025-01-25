package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FingerCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = Integer.parseInt(br.readLine());
        long answer = 0;
        switch (n) {
            case 1:
            case 5:
                answer = 8 * count + n - 1;
                break;
            default:
                if (count % 2 == 0) {
                    answer = 4 * count + n - 1;
                } else {
                    answer = 4 * (count + 1) - n + 1;
                }
        }
        System.out.println(answer);
    }

}
