package org.example.solv.marathon.course034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CardNumberProductCalculator {

    static Set<Integer> set = new HashSet<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        function(1, 0, 1);
        System.out.println(set.size());
    }

    public static void function(int index, int count, int num) {
        if (count == n) {
            set.add(num);
        } else {
            for (int i = index; i < 10; i++) {
                function(i, count + 1, num * i);
            }
        }
    }
}
