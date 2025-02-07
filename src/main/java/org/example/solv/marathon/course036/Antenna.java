package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Antenna {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(quickSelect(arr, 0, N - 1, (N - 1) / 2));
    }

    static int quickSelect(int[] arr, int left, int right, int mid) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right);
        if (mid == pivotIndex) {
            return arr[mid];
        } else if (mid < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, mid);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, mid);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    static void swap(int[] arr, int a, int b) {
        if (a == b) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
