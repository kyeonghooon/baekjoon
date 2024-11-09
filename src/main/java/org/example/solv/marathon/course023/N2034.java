package org.example.solv.marathon.course023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2034 {

    static char[] scales = new char[]{
            'A', 'X', 'B', 'C', 'X', 'D', 'X', 'E', 'F', 'X', 'G', 'X'
    };
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < scales.length; i++) {
            if (scales[i] == 'X') {
                continue;
            }
            char last = proc(i);
            if (last != 'X') {
                sb.append(scales[i]).append(" ").append(last).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static char proc(int index) {
        for (int i = 0; i < list.length; i++) {
            index += list[i];
            while (index < 0){
                index = index < 0 ? index + scales.length : index;
            }
            index = index % scales.length;
            if (scales[index] == 'X') {
                break;
            }
        }
        return scales[index];
    }

}
