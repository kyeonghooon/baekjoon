package org.example.solv.marathon.course023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N28464 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int highIndex = arr.length - 1;
        int lowIndex = 0;
        int highSum = 0;
        int lowSum = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            highSum += arr[highIndex];
            lowSum += arr[lowIndex];
            highIndex--;
            lowIndex++;
        }
        if (highIndex >= lowIndex) {
            highSum += arr[highIndex];
        }
        System.out.println(lowSum + " " + highSum);

    }

}
