package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arrStr = br.readLine().replaceAll("[\\[\\]]","").split(",");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
               arr[j] = Integer.parseInt(arrStr[j]);
            }
            boolean success = true;
            boolean reversed = false;
            int left = 0;
            int right = n - 1;
            int size = right - left;
            for (int j = 0; j < function.length(); j++) {
                char c = function.charAt(j);
                size = right - left + 1;
                if (c == 'R') reversed = !reversed;
                else {
                    if (size == 0){
                        success = false;
                        break;
                    }
                    else if (reversed) size = --right - left + 1;
                    else size = right - ++left + 1;
                }
            }
            if (success) {
                sb.append("[");
                for (int j = 0; j < size; j++) {
                    if (reversed) sb.append(arr[right - j]).append(",");
                    else sb.append(arr[left + j]).append(",");
                    if (j == size - 1) sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]").append("\n");
            } else {
                sb.append("error").append("\n");
            }

        }
        System.out.println(sb);
    }

}
