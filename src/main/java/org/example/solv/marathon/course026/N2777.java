package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2777 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            if (N < 10) {
                sb.append(1).append('\n');
                continue;
            }
            while (N > 1) {
                boolean divided = false;
                for (int j = 9; j > 1; j--) {
                    if (N % j == 0) {
                        N /= j;
                        count++;
                        divided = true;
                        break;
                    }
                }
                if (!divided) {
                    count = -1;
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

}
