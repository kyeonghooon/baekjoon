package org.example.solv.marathon.course021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24840 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }
            int mod = sum % 9;
            StringBuilder sb2 = new StringBuilder(str);
            if (mod == 0) {
                sb2.insert(1, '0');
                sb.append("Case #").append(i).append(": ").append(sb2.toString()).append('\n');
                continue;
            }

            String input = String.valueOf(9 - mod);
            boolean inserted = false;
            for (int j = 0; j < sb2.length(); j++) {
                if (sb2.charAt(j) - '0' > Integer.parseInt(input)) {
                    sb2.insert(j, input);
                    inserted = true;
                    break;
                }

            }
            if (!inserted) {
                sb2.append(input);
            }
            sb.append("Case #").append(i).append(": ").append(sb2.toString()).append('\n');
        }
        System.out.println(sb);
    }

}
