package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            String s = br.readLine();
            int n = s.length();
            long[] digits = new long[n];
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) == '6' ? 9 : s.charAt(i) - '0';
            }
            Arrays.sort(digits);
            int idx = s.length() - 1;
            long a = 0, b = 0;
            while (idx >= 0) {
                if (a > b) {
                    b *= 10L;
                    b += digits[idx--];
                } else {
                    a *= 10L;
                    a += digits[idx--];
                }
            }
            sb.append(a * b).append("\n");
        }
        System.out.println(sb);
    }
}
