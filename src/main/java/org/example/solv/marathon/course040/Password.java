package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuilder sb = new StringBuilder();
        while (!(str = br.readLine()).equals("end")) {
            sb.append("<").append(str).append(">").append(" is ");
            if (!check(str)) sb.append("not ");
            sb.append("acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        boolean vowelFound = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
                consonantCount = 0;
                vowelFound = true;
            } else {
                consonantCount++;
                vowelCount = 0;
            }
            if (i == 0) continue;
            if (c == str.charAt(i - 1) && c != 'e' && c != 'o') return false;
            if (vowelCount == 3 || consonantCount == 3) return false;
        }
        if (!vowelFound) return false;
        return true;
    }

}
