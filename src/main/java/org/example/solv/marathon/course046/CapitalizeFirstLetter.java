package org.example.solv.marathon.course046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitalizeFirstLetter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
                String line = br.readLine();
                sb.append(line.substring(0, 1).toUpperCase());
                sb.append(line.substring(1));
                sb.append(" ");
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.println(sb);
    }
}
