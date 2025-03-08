package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieBooking {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);
        int K = Integer.parseInt(splits[2]);
        int ans = 0;
        while (N-- > 0) {
            int zeroCount = 0;
            String str = br.readLine();
            for (int i = 0; i < M; i++) {
                char c = str.charAt(i);
                if (c == '1') {
                    zeroCount = 0;
                } else {
                    zeroCount++;
                    if (zeroCount >= K) ans++;
                }
            }
        }
        System.out.println(ans);
    }

}
