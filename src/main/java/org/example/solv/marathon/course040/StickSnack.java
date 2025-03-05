package org.example.solv.marathon.course040;

import java.io.IOException;

public class StickSnack {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        System.out.println(n * m % 3 == 0 ? "YES" : "NO");
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
