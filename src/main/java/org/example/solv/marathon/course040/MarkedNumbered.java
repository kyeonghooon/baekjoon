package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkedNumbered {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        int[] arr = new int[C];
        int[] level = new int[100002];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int depth = 0;
        if (arr[0] != 1) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < C; i++) {
            depth = Math.max(depth, arr[i]);
            if (i > 0 && arr[i] > arr[i - 1] + 1) {
                sb = new StringBuilder("-1");
                break;
            }
            if (i > 0 && arr[i] < arr[i - 1]) {
                for (int j = arr[i] + 1; j <= depth; j++) {
                    level[j] = 0;
                }
                depth = arr[i];
            }
            sb.append(++level[arr[i]]).append(" ");
        }
        System.out.println(sb);
    }

}
