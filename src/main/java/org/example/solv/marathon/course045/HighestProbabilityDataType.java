package org.example.solv.marathon.course045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighestProbabilityDataType {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N >= Short.MIN_VALUE && N <= Short.MAX_VALUE) {
            System.out.println("short");
        } else if (N >= Integer.MIN_VALUE && N <= Integer.MAX_VALUE) {
            System.out.println("int");
        } else {
            System.out.println("long long");
        }

    }
}
