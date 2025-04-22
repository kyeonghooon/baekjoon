package org.example.solv.marathon.course046;

import java.io.BufferedReader;
import java.io.IOException;

public class Akaraka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String S = br.readLine();
        System.out.println(isAkaraka(S) ? "AKARAKA" : "IPSELENTI");
    }

    public static boolean isAkaraka(String s) {
        int len = s.length();
        if (len == 1) return true;
        if (!isPalindrome(s)) return false;

        int half = len / 2;
        String prefix = s.substring(0, half);
        String suffix = s.substring(len - half);

        return isAkaraka(prefix) && isAkaraka(suffix);
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}
