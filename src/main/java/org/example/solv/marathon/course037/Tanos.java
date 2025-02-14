package org.example.solv.marathon.course037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tanos {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        count[0] = count[0] / 2;
        count[1] = count[1] / 2;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                if (count[1] > 0) {
                    count[1]--;
                } else {
                    sb.append(1);
                }
            } else {
                if (count[0] > 0) {
                    sb.append(0);
                    count[0]--;
                }
            }
        }
        System.out.println(sb);
    }

}
