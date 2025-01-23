package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortAlgorithm {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int[] arr = new int[N];
        count = Integer.parseInt(splits[1]);
        splits = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        quickSort(arr, 0, N - 1);
        if (count > 0) System.out.println(-1);
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition (int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                if (--count == 0) {
                    System.out.println(arr[i] + " " + arr[j]);
                    System.exit(0);
                }
            }
        }
        if (i + 1 != r) {
            int temp = arr[r];
            arr[r] = arr[i + 1];
            arr[i + 1] = temp;
            if (--count == 0) {
                System.out.println(arr[i + 1] + " " + arr[r]);
                System.exit(0);
            }
        }
        return i + 1;
    }
}
