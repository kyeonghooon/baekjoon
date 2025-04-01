package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SchoolMealDistribution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer>[] meals = new Map[N + 1];
        for (int i = 1; i <= N; i++) {
            meals[i] = new HashMap<>();
        }
        for (int student = 0; student < M; student++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for (int j = 0; j < l; j++) {
                int p = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                meals[p].put(student, v);
            }
        }
        long totalSum = 0;
        for (int i = 1; i <= N; i++) {
            if (meals[i].isEmpty()) continue;
            List<Integer> studentIndices = new ArrayList<>(meals[i].keySet());
            Collections.sort(studentIndices);
            int k = studentIndices.size();
            long[] dp = new long[k];
            dp[0] = meals[i].get(studentIndices.get(0));
            if (k > 1) {
                int idx0 = studentIndices.get(0);
                int idx1 = studentIndices.get(1);
                int v1 = meals[i].get(studentIndices.get(1));
                if (idx1 == idx0 + 1) {
                    dp[1] = Math.max(dp[0], v1);
                } else {
                    dp[1] = dp[0] + v1;
                }
            }
            for (int j = 2; j < k; j++) {
                int curIdx = studentIndices.get(j);
                int prevIdx = studentIndices.get(j - 1);
                int curVal = meals[i].get(curIdx);
                if (curIdx == prevIdx + 1) {
                    dp[j] = Math.max(dp[j - 1], dp[j - 2] + curVal);
                } else {
                    dp[j] = dp[j - 1] + curVal;
                }
            }
            totalSum += dp[k - 1];
        }
        System.out.println(totalSum);
    }
}
