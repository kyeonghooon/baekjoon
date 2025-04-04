package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicCompass {

    static int xMin = Integer.MIN_VALUE;
    static int yMin = Integer.MIN_VALUE;
    static int xMax = Integer.MAX_VALUE;
    static int yMax = Integer.MAX_VALUE;
    static int answerX = 0, answerY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            calculate(x, y, k);
        }
        StringBuilder sb = new StringBuilder();
        if (answerX != 0) {
            sb.append(answerX).append(" ");
        } else {
            for (int i = 1; i <= N; i++) {
                if (i > xMin && i < xMax) {
                    sb.append(i).append(" ");
                    break;
                }
            }
        }
        if (answerY != 0) {
            sb.append(answerY);
        } else {
            for (int i = 1; i <= N; i++) {
                if (i > yMin && i < yMax) {
                    sb.append(i).append(" ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static void calculate(int x, int y, int k) {
        switch (k) {
            case 1:
                xMax = Math.min(xMax, x);
                answerY = y;
                break;
            case 2:
                xMax = Math.min(xMax, x);
                yMin = Math.max(yMin, y);
                break;
            case 3:
                answerX = x;
                yMin = Math.max(yMin, y);
                break;
            case 4:
                xMin = Math.max(xMin, x);
                yMin = Math.max(yMin, y);
                break;
            case 5:
                xMin = Math.max(xMin, x);
                answerY = y;
                break;
            case 6:
                xMin = Math.max(xMin, x);
                yMax = Math.min(yMax, y);
                break;
            case 7:
                answerX = x;
                yMax = Math.min(yMax, y);
                break;
            case 8:
                xMax = Math.min(xMax, x);
                yMax = Math.min(yMax, y);
                break;
        }
    }
}
