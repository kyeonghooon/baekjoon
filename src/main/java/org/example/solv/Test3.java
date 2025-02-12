package org.example.solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        int[] str1Arr = new int[26];
        for (char c : str1.toCharArray()) {
            str1Arr[c - 'A']++;
        }
        N--;
        int answer = 0;
        while(N-- > 0) {
            String str2 = br.readLine();
            int count1 = str1.length();
            int count2 = 0;
            int[] str1ArrCopy = str1Arr.clone();
            for (char c : str2.toCharArray()) {
                if (str1ArrCopy[c - 'A'] > 0) {
                    str1ArrCopy[c - 'A']--;
                    count1--;
                } else {
                    count2++;
                }
            }
            if (count1 < 2 && count2 < 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
