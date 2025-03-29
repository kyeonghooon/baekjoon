package org.example.solv.marathon.course043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1_000_000_000;
        int[] primes = setPrimeNumbers((int) Math.sqrt(mod));
        Map<Integer, Integer> aFactors = new HashMap<>();
        Map<Integer, Integer> bFactors = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(input[i]);
            accumulateFactors(aFactors, primes, a);
        }
        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(input[i]);
            accumulateFactors(bFactors, primes, b);
        }
        long answerMod = 1;
        boolean over = false;
        for (int prime : aFactors.keySet()) {
            if (bFactors.containsKey(prime)) {
                int min = Math.min(aFactors.get(prime), bFactors.get(prime));
                while (min-- > 0) {
                    answerMod *= prime;
                    if (over) {
                        answerMod %= mod;
                    } else if (answerMod >= mod) {
                        over = true;
                        answerMod %= mod;
                    }
                }
            }
        }
        if (over) {
            System.out.printf("%09d", answerMod);
        } else {
            System.out.println(answerMod);
        }
    }

    static int[] setPrimeNumbers(int limit) {
        boolean[] noPrime = new boolean[limit + 1];
        noPrime[0] = true;
        noPrime[1] = true;
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (!noPrime[i]) {
                primesList.add(i);
                for (int j = i * i; j <= limit; j += i) {
                    noPrime[j] = true;
                }
            }
        }
        return primesList.stream().mapToInt(i -> i).toArray();
    }

    static void accumulateFactors(Map<Integer, Integer> factors, int[] primes, int n) {
        for (int i = 0; i < primes.length; i++) {
            while (n % primes[i] == 0) {
                n /= primes[i];
                factors.put(primes[i], factors.getOrDefault(primes[i], 0) + 1);
            }
        }
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
    }

}
