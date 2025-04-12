package org.example.solv.marathon.course045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberAppender {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean found = false;
            while (!found) {
                if (sb.length() <= idx) {
                    sb.append(++count);
                }
                if (sb.charAt(idx) == str.charAt(i)) {
                    found = true;
                }
                idx++;
            }
        }
        System.out.println(count);
    }
}
