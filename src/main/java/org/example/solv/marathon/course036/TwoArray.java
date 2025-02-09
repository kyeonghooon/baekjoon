package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            int n = Integer.parseInt(splits[0]);
            int m = Integer.parseInt(splits[1]);
            splits = br.readLine().split(" ");
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(splits[i]);
            }
            splits = br.readLine().split(" ");
            int[] B = new int[m];
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(splits[i]);
            }
            Arrays.sort(B);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int num = A[i];
                sum += binarySearch(B, num);
            }
            System.out.println(sum);
        }
    }

    static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return arr[mid];
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= arr.length) {
            return arr[arr.length - 1];
        }
        if (left == 0) {
            return arr[0];
        }
        if (Math.abs(arr[left] - num) < Math.abs(arr[left - 1] - num)) {
            return arr[left];
        } else {
            return arr[left - 1];
        }
    }

}
