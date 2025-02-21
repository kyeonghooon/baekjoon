package org.example.solv.marathon.course038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chromosome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            char prev = ' ';
            boolean fail = false;
            boolean start = false;
            boolean end = false;
            for (char c : str.toCharArray()) {
                if (c > 'F' || end) {
                    fail = true;
                    break;
                }
                if (start) {
                    if (c == 'A') {
                        start = false;
                        prev = c;
                        continue;
                    } else {
                        fail = true;
                        break;
                    }
                }
                switch (prev) {
                    case ' ':
                        prev = c;
                        if (c == 'A') break;
                        start = true;
                        break;
                    case 'A':
                        if (c == 'A' || c == 'F') prev = c;
                        else fail = true;
                        break;
                    case 'F':
                        if (c == 'F' || c == 'C') prev = c;
                        else fail = true;
                        break;
                    case 'C':
                        prev = c;
                        if (c != 'C') end = true;
                        break;
                }
                if (fail) break;
            }
            if (fail) System.out.println("Good");
            else System.out.println("Infected!");
        }
    }

}
