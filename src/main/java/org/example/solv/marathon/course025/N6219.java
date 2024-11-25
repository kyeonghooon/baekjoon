package org.example.solv.marathon.course025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N6219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        String D = split[2];
        List<String> primes = getPrimes(A, B);
        int count = 0;
        for (String prime: primes) {
            if (prime.contains(D)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static List<String> getPrimes(int A, int B) {
        List<String> primes = new ArrayList<String>();
        boolean[] isPrime = new boolean[B + 1];
        for (int i = 0; i <= B; i++) {
            isPrime[i] = true;
        }
        if(B >= 0) isPrime[0] = false;
        if(B >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= B; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= B; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = A; i <= B; i++) {
            if(isPrime[i]) {
                primes.add(String.valueOf(i));
            }
        }
        return primes;
    }

}
