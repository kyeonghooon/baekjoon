package org.example.solv.marathon.course021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4575 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = null;
        while (!(str = br.readLine()).equals("END")) {
            char[] ch = str.toCharArray();
            boolean flag = false;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] != ' ' && (str.indexOf(ch[i]) != str.lastIndexOf(ch[i]))) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
