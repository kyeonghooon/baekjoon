package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodCompression {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long max = 0;
        for (int i = 0; i <= b; i++) {
            max += (long) Math.pow(2, i);
        }
        if (max >= n) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
