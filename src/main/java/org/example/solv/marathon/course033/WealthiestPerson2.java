package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class WealthiestPerson2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        BigInteger n = new BigInteger(splits[0]);
        BigInteger m = new BigInteger(splits[1]);
        BigInteger[] result = n.divideAndRemainder(m);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
