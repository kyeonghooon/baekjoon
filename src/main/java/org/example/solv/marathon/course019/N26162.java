package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N26162 {

    private static boolean[] primeNumbers = new boolean[119];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Arrays.fill(primeNumbers, true);
        setPrimeNumbers();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean check = false;
            int a = Integer.parseInt(br.readLine());
            for (int j = 2; j <= a / 2; j++) {
                if (primeNumbers[j] && primeNumbers[a - j]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                sb.append("Yes\n");
            } else {
				sb.append("No\n");
			}
        }
        System.out.println(sb.toString());
    }

    private static void setPrimeNumbers() {
        primeNumbers[0] = false;
        primeNumbers[1] = false;
        for (int i = 2; i * i < primeNumbers.length; i++) {
            if (primeNumbers[i]) {
                // i * i 이전의 i의 배수들은 이미 처리된 상태
                for (int j = i * i; j < primeNumbers.length; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }
    }

}
