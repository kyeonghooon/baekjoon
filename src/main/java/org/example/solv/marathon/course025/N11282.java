package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 44031;
        char c = (char) N;
        System.out.println(c);
    }

}
