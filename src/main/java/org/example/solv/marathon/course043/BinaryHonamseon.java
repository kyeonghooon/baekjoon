package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryHonamseon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("? 1");
        System.out.flush();
        int first = Integer.parseInt(br.readLine());
        System.out.println("? " + N);
        System.out.flush();
        int end = Integer.parseInt(br.readLine());
        int answer = end - first;
        System.out.println("! " + answer);
    }
}
