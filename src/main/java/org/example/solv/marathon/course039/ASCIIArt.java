package org.example.solv.marathon.course039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASCIIArt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);
        while (N-- > 0) {
            splits = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                int R = Integer.parseInt(splits[i * 3]);
                int G = Integer.parseInt(splits[i * 3 + 1]);
                int B = Integer.parseInt(splits[i * 3 + 2]);
                sb.append(intensityfunction(R, G, B));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static char intensityfunction(int R, int G, int B) {
        int sum = 2126 * R + 7152 * G + 722 * B;
        char c = '#';
        if (sum >= 510_000 && sum < 1_020_000) {
            c = 'o';
        } else if (sum >= 1_020_000 && sum < 1_530_000) {
            c = '+';
        } else if (sum >= 1_530_000 && sum < 2_040_000) {
            c = '-';
        } else if (sum >= 2_040_000) {
            c = '.';
        }
        return c;
    }

}
