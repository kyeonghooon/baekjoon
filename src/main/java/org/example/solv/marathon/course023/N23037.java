package org.example.solv.marathon.course023;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N23037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        for (char c : str.toCharArray()) {
            int num = c - '0';
            sum += Math.pow(num, 5);
        }
        System.out.println(sum);
    }

}
