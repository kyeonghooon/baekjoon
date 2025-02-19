package org.example.solv.marathon.course038;

import java.io.IOException;

public class ArchitectureKing {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int startX = readInt();
        int startY = readInt();
        int answer = 0;
        int prevX = startX;
        int prevY = startY;
        for (int i = 1; i < N; i++) {
            int x = readInt();
            int y = readInt();
            answer += Math.abs(x - prevX) + Math.abs(y - prevY);
            prevX = x;
            prevY = y;
        }
        answer += Math.abs(prevX - startX) + Math.abs(prevY - startY);
        System.out.println(answer);
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
