package org.example.solv.marathon.course045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AttendanceCheck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] attendance = new boolean[N + 3];
        boolean[] sleeps = new boolean[N + 3];
        while (K-- > 0) {
            sleeps[Integer.parseInt(st.nextToken())] = true;
        }
        st = new StringTokenizer(br.readLine());
        while (Q-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            if (sleeps[n]) continue;
            for (int i = n; i < attendance.length; i += n) {
                if (sleeps[i]) continue;
                attendance[i] = true;
            }
        }
        int[] dp = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            dp[i] = dp[i - 1] + (attendance[i] ? 0 : 1);
        }
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end] - dp[start - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
