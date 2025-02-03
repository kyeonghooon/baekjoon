package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gazua {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if ((k & (k - 1)) == 0) {
                sb.append("GoHanGang").append("\n");
            } else {
                sb.append("Gazua").append("\n");
            }
        }
        System.out.println(sb);
    }

}
