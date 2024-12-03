package org.example.solv.marathon.course026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N26152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer A  = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(A.nextToken());
            int b = Integer.parseInt(B.nextToken());
            arr[i] = a - b;
        }
        int[] prefixMin = new int[N];
        prefixMin[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
        }
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int w = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            int result = N;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefixMin[mid] >= w) {
                    left = mid + 1;
                } else {
                    result = mid;
                    right = mid - 1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}
