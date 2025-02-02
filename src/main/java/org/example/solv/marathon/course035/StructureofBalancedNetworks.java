package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StructureofBalancedNetworks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] list = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = str.charAt(j * 2) == '+';
            }
        }
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] splits = br.readLine().split(" ");
            int b = Integer.parseInt(splits[0]);
            int c = Integer.parseInt(splits[1]);
            System.out.println(list[b][c] ? '+' : '-');
        }
    }

}
