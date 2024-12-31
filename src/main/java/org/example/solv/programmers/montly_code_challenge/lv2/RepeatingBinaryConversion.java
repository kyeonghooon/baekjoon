package org.example.solv.programmers.montly_code_challenge.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatingBinaryConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = solution(br.readLine());
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            String decStr = binaryConversion(s, answer);
            s = Integer.toBinaryString(decStr.length());
        }
        return answer;
    }

    public static String binaryConversion(String s, int[] answer) {
        String newStr = s.replace("0", "");
        int zeroCount = s.length() - newStr.length();
        answer[0]++;
        answer[1] += zeroCount;
        return newStr;
    }

}
