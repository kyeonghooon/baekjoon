package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            String reverse = new StringBuilder(s).reverse().toString();
            int overlap = 0;
            for (int i = 1; i <= s.length(); i++) {
                if (s.substring(s.length() - i).equals(reverse.substring(0, i))) {
                    overlap = i;
                }
            }
            sb.append(s).append(reverse.substring(overlap)).append("\n");
        }
        System.out.println(sb);
    }
}
