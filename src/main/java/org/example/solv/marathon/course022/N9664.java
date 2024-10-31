package org.example.solv.marathon.course022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9664 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int O = Integer.parseInt(br.readLine());
        int mod = O / (N - 1);
        int max = O + mod;
        int min = 0;
        if (max % N == 0) {
            min = max - 1;
        } else {
            min = max;
        }
        System.out.println(min + " " + max);
    }
}
