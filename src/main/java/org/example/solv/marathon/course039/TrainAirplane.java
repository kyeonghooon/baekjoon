package org.example.solv.marathon.course039;

import java.io.IOException;

public class TrainAirplane {

    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();
        System.out.println(a <= b ? "high speed rail" : "flight");
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
