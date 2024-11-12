package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N26004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int[] arr = new int[5];
        for (char c : S.toCharArray()) {
            switch (c) {
                case 'H': arr[0]++; break;
                case 'I': arr[1]++; break;
                case 'A': arr[2]++; break;
                case 'R': arr[3]++; break;
                case 'C': arr[4]++; break;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

}
