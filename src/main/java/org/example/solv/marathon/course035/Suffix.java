package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Suffix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                String s = str.substring(str.length() - 1 - i);
                if (!set.add(s)) set.remove(s);
            }
        }
        System.out.println(set.size());
    }

}
