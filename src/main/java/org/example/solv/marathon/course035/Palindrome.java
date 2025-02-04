package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            int left = 0;
            int right = str.length() - 1;
            boolean isPalindrome = true;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    isPalindrome = false;
                    if (isPseudoPalindrome(str, left + 1, right) || isPseudoPalindrome(str, left, right - 1)) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("2").append("\n");
                    }
                    break;
                }
                left++;
                right--;
            }
            if (isPalindrome) {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isPseudoPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
