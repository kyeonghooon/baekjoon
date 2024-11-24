package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N32218 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        while (true) {
            int check = 0;
            for (int i = 0; i < N; i++) {
                int count = 0;
                int curNum = A[i];
                for (int j = i + 1; j < N; j++) {
                    if (curNum < A[j]) {
                        count++;
                    }
                }
                B[i] = count;
                if (A[i] == B[i]) {
                    check++;
                } else {
                    A[i] = B[i];
                }
            }
            result++;
            if (check == N) break;
        }
        System.out.println(result);
    }

}
