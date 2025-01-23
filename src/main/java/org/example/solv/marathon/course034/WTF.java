package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WTF {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.length() > 2 && str.startsWith("\"") && str.endsWith("\"")) {
            System.out.println(str.substring(1, str.length() - 1));
        } else {
            System.out.println("CE");
        }
    }

}
