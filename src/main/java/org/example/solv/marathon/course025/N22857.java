package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N22857 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int oddCount = 0;
        int currentEvenCount = 0;
        int maxEvenCount = 0;

        for (int right = 0; right < N; right++) {
            if (arr[right] % 2 != 0) {
                oddCount++;
            } else {
                currentEvenCount++;
            }

            while (oddCount > K) {
                if (arr[left] % 2 != 0) {
                    oddCount--;
                } else {
                    currentEvenCount--;
                }
                left++;
            }

            if (currentEvenCount > maxEvenCount) {
                maxEvenCount = currentEvenCount;
            }
        }

        System.out.println(maxEvenCount);
    }

}
