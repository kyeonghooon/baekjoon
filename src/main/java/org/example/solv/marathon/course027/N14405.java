package org.example.solv.marathon.course027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean impossible = false;
        while (str.length() > 0) {
            str.replace("pi","");
            str.replace("ka","");
            str.replace("chu","");
            if (!str.contains("pi") && !str.contains("ka") && !str.contains("chu")) {
                impossible = true;
                break;
            }
        }
        if (impossible) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

}
