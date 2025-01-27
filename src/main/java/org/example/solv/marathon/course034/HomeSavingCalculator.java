package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HomeSavingCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        String[] splits = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[Integer.parseInt(splits[i - 1])] = i;
        }
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            splits = br.readLine().split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            int[] indexArr = new int[end - start + 1];
            for (int index = 0, value = start; index < indexArr.length; index++, value++) {
                indexArr[index] = arr[value];
            }
            Arrays.sort(indexArr);
            int[] result = new int[N + 1];
            for (int i = 1, a = 0; i <= N; i++) {
                if (i < start || i > end) {
                    result[arr[i]] = i;
                } else {
                    result[indexArr[a++]] = i;
                }
            }
            for (int i = 1; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
