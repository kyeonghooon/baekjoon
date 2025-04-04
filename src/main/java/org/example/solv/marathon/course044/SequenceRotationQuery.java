package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceRotationQuery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        arr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int left = 1;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k;
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    k = Integer.parseInt(st.nextToken());
                    left = left > k ? left - k : N + left - k;
                    break;
                case 2:
                    k = Integer.parseInt(st.nextToken());
                    left += k;
                    if (left > N) left -= N;
                    break;
                case 3:
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int start = (left + a - 1);
                    if (start > N) start -= N;
                    int end = (left + b - 1);
                    if (end > N) end -= N;
                    long sum = arr[end] - arr[start - 1] + ((start > end) ? arr[N] : 0);
                    sb.append(sum).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
