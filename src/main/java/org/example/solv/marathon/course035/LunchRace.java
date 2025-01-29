package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LunchRace {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int n = Integer.parseInt(splits[0]);
        int m = Integer.parseInt(splits[1]);
        int y = 1;
        int x = m + 1;
        int k = Integer.parseInt(splits[2]);
        int answer = 0;
        int lowScore = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            splits = br.readLine().split(" ");
            int curY = Integer.parseInt(splits[0]);
            int curX = Integer.parseInt(splits[1]);
            int score = curY - y + x - curX;
            if (lowScore > score) {
                answer = i;
                lowScore = score;
            }
        }
        System.out.println(answer);
    }

}
