package org.example.solv.marathon.course027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N27294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int time = Integer.parseInt(splits[0]);
        int drink = Integer.parseInt(splits[1]);
        if (drink == 0 && time >= 12 && time <= 16) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
    }

}
