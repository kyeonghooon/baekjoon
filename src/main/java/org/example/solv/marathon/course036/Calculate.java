package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int a = Integer.parseInt(splits[0]);
        int b = Integer.parseInt(splits[1]);
        int c = splits[2].charAt(splits[2].length() - 1) - '0';
        int result = a ^ b;
        if (c % 2 == 0) {
            result = a;
        }
        System.out.println(result);
    }

}
