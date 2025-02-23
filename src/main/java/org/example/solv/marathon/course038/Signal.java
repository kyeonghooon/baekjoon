package org.example.solv.marathon.course038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Signal {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = N / 5;
        int[] arr = new int[length];
        String str = br.readLine();
        for (int i = 0; i < 5; i++) {
            String part = str.substring(0 + i * length, length + i * length);
            for (int j = 0; j < length; j++) {
                arr[j] += (part.charAt(j) == '#' ? 1 : 0) * Math.pow(2, i);
            }
        }
        int index = 0;
        while (index < length) {
            index = print(arr, index);
        }
        System.out.println(sb);
    }

    static int print(int[] arr, int index) {
        if (arr[index] == 0) return index + 1;
        // 0, 1, 6, 8
        if (arr[index] == 31) {
            // 1
            if (index == arr.length - 1 || arr[index + 1] == 0) {
                sb.append(1);
                return index + 2;
            }
            // 0
            if (arr[index + 1] == 17) {
                sb.append(0);
                return index + 3;
            }
            // 6
            if (arr[index + 2] == 29) {
                sb.append(6);
                return index + 3;
            }
            // 8
            if (arr[index + 2] == 31) {
                sb.append(8);
                return index + 3;
            }
        }
        // 2
        if (arr[index] == 29) {
            sb.append(2);
            return index + 3;
        }
        // 3
        if (arr[index] == 21) {
            sb.append(3);
            return index + 3;
        }
        // 4
        if (arr[index] == 7) {
            sb.append(4);
            return index + 3;
        }
        // 5 , 9
        if (arr[index] == 23) {
            if (arr[index + 2] == 31) {
                sb.append(9);
                return index + 3;
            } else {
                sb.append(5);
                return index + 3;
            }
        }
        // 7
        sb.append(7);
        return index + 3;
    }
}
