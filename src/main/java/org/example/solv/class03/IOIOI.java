package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class IOIOI {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int count = 0;
        int result = 0;
        for (int i = 1; i < M; i++) {
            if (str.charAt(i - 1) == 'I' && str.charAt(i) == 'O') {
                count++;
                if (i + 1 < M && str.charAt(i + 1) == 'I') {
                    if(count >= N) {
                        result++;
                    }
                    i++;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(result);
    }

}
