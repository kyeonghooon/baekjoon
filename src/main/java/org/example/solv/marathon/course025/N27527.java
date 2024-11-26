package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N27527 {

    private static final int SIZE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minCount = (int) Math.ceil((9.0 * M) / 10.0);
        int[] cnt = new int[SIZE];
        int left = 0;
        boolean found = false;

        for (int right = 0; right < N; right++) {
            cnt[arr[right]]++;

            if (right - left + 1 > M) {
                cnt[arr[left]]--;
                left++;
            }

            if (cnt[arr[right]] >= minCount) {
                found = true;
                break;
            }
        }

        System.out.print(found ? "YES" : "NO");
    }

}
