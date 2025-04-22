package org.example.solv.marathon.course046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrickFlower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[R][R];
        int count = 0;
        while (!arr[a][b]) {
            arr[a][b] = true;
            if (a + b + 2 < R) {
                a++;
                b++;
            } else {
                a /= 2;
                b /= 2;
            }
            count++;
        }
        System.out.println(count);
    }
}
