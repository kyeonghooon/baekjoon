package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N22351 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        for (int start = 0; start < 1000; start++) {
            int cur = start;
            int index = 0;
            while (index < length) {
                String numStr = String.valueOf(cur);
                int numLen = numStr.length();
                if (index + numLen > length) {
                    break;
                }
                if (str.startsWith(numStr, index)) {
                    index += numLen;
                    cur++;
                } else {
                    break;
                }
            }
            if (index == length) {
                int end = cur - 1;
                System.out.println(start + " " + end);
                return;
            }
        }
    }

}
