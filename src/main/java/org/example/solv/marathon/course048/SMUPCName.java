package org.example.solv.marathon.course048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SMUPCName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        String name = input[1];
        StringBuffer sb = new StringBuffer();
        boolean[] used = new boolean['z' - 'a' + 1];
        // 1
        for (char ch : name.toCharArray()) {
            if (!used[ch - 'a']) {
                sb.append(ch);
                used[ch - 'a'] = true;
            }
        }
        // 2
        sb.append(name.length() - sb.length() + 4);
        // 3
        sb.insert(0, 1906 + num);
        // 4
        sb.reverse();
        // 5
        sb.insert(0, "smupc_");
        System.out.println(sb);
    }
}
