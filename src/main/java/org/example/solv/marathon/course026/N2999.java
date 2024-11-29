package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N2999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int r = 0;
        int c = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                c = n / i;
                r = i;
            }
        }
        char[][] secure = new char[c][r];
        int index = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                secure[i][j] = str.charAt(index++);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(secure[j][i]);
            }
        }
    }

}
