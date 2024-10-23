package org.example.solv.marathon.course021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N23055 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (n == 1){
            System.out.println("*");
            return;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j || i == 0 || j == 0 || i == n - 1 || j == n - 1 || i + j == n - 1){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
