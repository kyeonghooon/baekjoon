package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int totalMonths = Integer.parseInt(st.nextToken());
            int monthlyDays = Integer.parseInt(st.nextToken());
            int weeklyDays = Integer.parseInt(st.nextToken());
            int result = ((totalMonths * monthlyDays) + (weeklyDays - 1)) / weeklyDays;
            for (int j = 0; j < totalMonths; j++) {
                if ((j * monthlyDays) % weeklyDays > 0) {
                    result++;
                }
            }
            sb.append("Case #").append(i + 1).append(": ").append(result).append("\n");
        }
        System.out.println(sb);
    }

}
