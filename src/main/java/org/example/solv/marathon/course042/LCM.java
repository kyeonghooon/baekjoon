package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int gcd = gcd(a, b);
            sb.append(gcd * (a / gcd) * (b / gcd)).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
