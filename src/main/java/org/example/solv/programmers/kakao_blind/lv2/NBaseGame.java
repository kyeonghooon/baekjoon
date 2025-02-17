package org.example.solv.programmers.kakao_blind.lv2;

public class NBaseGame {

    public static void main(String[] args) {
        System.out.println(new NBaseGame().solution(16, 16, 2, 2));
    }

    int number = 0;
    int counter = 1;
    StringBuilder sb = new StringBuilder();
    StringBuilder answerSb = new StringBuilder();

    public String solution(int n, int t, int m, int p) {
        while (answerSb.length() < t) {
            while (counter != p) {
                getNextDigit(n, m);
            }
            answerSb.append(getNextDigit(n, m));
        }
        return answerSb.toString();
    }

    private char getNextDigit(int n, int m) {
        if (sb.length() == 0) {
            sb.append(Integer.toString(number++, n).toUpperCase());
        }
        char digit = sb.charAt(0);
        sb.deleteCharAt(0);
        counter = (counter % m) + 1;
        return digit;
    }
}
