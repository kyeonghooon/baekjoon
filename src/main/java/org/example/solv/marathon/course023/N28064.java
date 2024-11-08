package org.example.solv.marathon.course023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N28064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (canConnect(names[i], names[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean canConnect(String s, String t) {
        int len = Math.min(s.length(), t.length());

        for (int k = 1; k <= len; k++) {
            if (s.substring(0, k).equals(t.substring(t.length() - k))) {
                return true;
            }
        }

        for (int k = 1; k <= len; k++) {
            if (s.substring(s.length() - k).equals(t.substring(0, k))) {
                return true;
            }
        }

        return false;
    }
}
