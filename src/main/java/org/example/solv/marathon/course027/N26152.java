package org.example.solv.marathon.course027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N26152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        String s = br.readLine();
        br.close();
        char[][] line = new char[5][s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 5; j++) {
                line[j][i] = nextChar(j, c);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < s.length(); j++) {
                sb.append(line[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static char nextChar(int line, char c) {
        switch (line) {
            case 0:
                switch (c) {
                    case 'o':
                        return 'o';
                    case 'w':
                    default:
                        return '.';
                }
            case 1:
                switch (c) {
                    case 'o':
                        return 'w';
                    case 'w':
                        return 'o';
                    default:
                        return '.';
                }
            case 2:
                switch (c) {
                    case 'o':
                        return 'l';
                    case 'w':
                        return 'm';
                    default:
                        return 'o';
                }
            case 3:
                switch (c) {
                    case 'o':
                        return 'n';
                    case 'w':
                        return 'l';
                    default:
                        return 'L';
                }
            case 4:
                switch (c) {
                    case 'o':
                        return '.';
                    case 'w':
                    default:
                        return 'n';
                }
            default:
                return c;
        }
    }

}
