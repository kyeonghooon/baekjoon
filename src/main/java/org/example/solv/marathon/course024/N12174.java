package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N12174 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": ");
            int B = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int j = 0; j < B; j++) {
                int s = j * 8;
                toChar(str.substring(s, s + 8));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void toChar(String str) {
        str = str.replace('O', '0');
        str = str.replace('I', '1');
        int ascii = Integer.parseInt(str, 2);
        sb.append((char)ascii);
    }

}
