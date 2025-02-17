package org.example.solv.programmers.kakao_blind.lv2;

public class CountPrimeNumber {

    public static void main(String[] args) {
        System.out.println(new CountPrimeNumber().solution(110011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String[] list = Integer.toString(n, k).split("0");
        for (String str : list) {
            if (str.isEmpty()) continue;
            long number = Long.parseLong(str);
            if (isPrime(number)) answer++;
        }
        return answer;
    }

    public boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
