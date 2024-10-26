package org.example.solv.marathon.course021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24399 {

    static int K;
    static int[] array;
    static StringBuffer sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        array = new int[N];
        int Q = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        select(array, 0, N - 1, Q);
        if (K > 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    public static int select(int[] A, int p, int r, int q) {
        if (K <= 0) {
            return 0;
        }
        if (p == r) {
            return A[p];
        }
        int t = partition(A, p, r);
        int k = t - p + 1;

        if (q < k) {
            return select(A, p, t - 1, q);
        } else if (q == k) {
            return A[t];
        } else {
            return select(A, t + 1, r, q - k);
        }
    }

    public static int partition(int[] A, int p, int r) {
        if (K <= 0) {
            return 0;
        }
        int x = A[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }

        if (i + 1 != r) {
            swap(A, i + 1, r);
        }

        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        if (--K == 0){
            for (int value : A) {
                sb.append(value).append(" ");
            }
        }
    }
}
