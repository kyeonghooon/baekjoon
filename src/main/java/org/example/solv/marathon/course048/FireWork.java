package org.example.solv.marathon.course048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FireWork {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int min = Integer.parseInt(input.substring(0, input.indexOf(" ")));
        int max = Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1));
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        int answer = 0;
        if (max - min >= N - 2) {
            answer = max - (N - 2);
        } else {
            answer = (min + max - (N - 1) + 1) / 2;
        }
        System.out.println(answer);
    }
}
