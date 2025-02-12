package org.example.solv.marathon.course037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UOString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[]{'S', 'U', 'O'};
        int N = Integer.parseInt(br.readLine());
        System.out.println(arr[N % 3]);
    }

}
