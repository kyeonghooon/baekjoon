package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N19843 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = converter(st.nextToken()) + Integer.parseInt(st.nextToken());
            int end = converter(st.nextToken()) + Integer.parseInt(st.nextToken());
            T -= (end - start);
        }
        if (T <= 0) {
            System.out.println(0);
        } else if (T > 48) {
            System.out.println(-1);
        } else {
            System.out.println(T);
        }
    }

    public static int converter(String weekDay) {
        switch (weekDay) {
            case "Mon":
                return 0;
            case "Tue":
                return 24;
            case "Wed":
                return 48;
            case "Thu":
                return 72;
            case "Fri":
                return 96;
            default:
                return 0;
        }
    }

}
