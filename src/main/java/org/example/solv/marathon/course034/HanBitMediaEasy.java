package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HanBitMediaEasy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        Arrays.sort(arr);
        int count = 1;
        int min = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] >= min * 2) {
                count++;
                min = arr[i];
            }
        }
        System.out.println(count);
    }

}
