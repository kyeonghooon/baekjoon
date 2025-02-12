package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hamming {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        long p1 = Long.parseLong(splits[0]);
        long p2 = Long.parseLong(splits[1]);
        long p3 = Long.parseLong(splits[2]);
        long i = Long.parseLong(splits[3]);

        long lo = Math.min(p1, Math.min(p2, p3));
        long hi = 1_000_000_000_000_000_000L;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countHamming(mid, p1, p2, p3) < i) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        System.out.println(lo);
    }

    static long countHamming(long X, long p1, long p2, long p3) {
        long count = 0;
        for (long a = 0, v1 = 1; ; a++) {
            if (v1 > X) break;
            for (long b = 0, v2 = 1; ; b++) {
                if (mulOverflow(v1, v2, X)) break;
                long prod = v1 * v2;
                for (long c = 0, v3 = 1; ; c++) {
                    if (mulOverflow(prod, v3, X)) break;
                    count++;
                    if (v3 > X / p3) break;
                    v3 *= p3;
                }
                if (v2 > X / p2) break;
                v2 *= p2;
            }
            if (v1 > X / p1) break;
            v1 *= p1;
        }
        if (X >= 1) count--;
        return count;
    }

    static boolean mulOverflow(long a, long b, long limit) {
        return a > limit / b;
    }
}
