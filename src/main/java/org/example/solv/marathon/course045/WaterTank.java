package org.example.solv.marathon.course045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterTank {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        double C = Double.parseDouble(st1.nextToken());
        double[] t = new double[n];
        double[] x = new double[n];
        double maxX = 0;
        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t[i] = Double.parseDouble(st1.nextToken());
            x[i] = Double.parseDouble(st2.nextToken());
            maxX = Math.max(maxX, x[i]);
        }
        double lo = 0;
        double hi = maxX + C;
        for (int iter = 0; iter < 100; iter++) {
            double mid = (lo + hi) / 2;
            if (isFeasible(mid, t, x, C))
                hi = mid;
            else
                lo = mid;
        }
        System.out.printf("%.10f",hi);
    }

    private static boolean isFeasible(double R, double[] t, double[] x, double C) {
        double level = 0;
        for (int i = 0; i < t.length; i++) {
            double net = x[i] - R;
            if (net > 0) {
                if (level + net * t[i] > C + 1e-12) { // 오차를 고려하여 체크
                    return false;
                }
                level += net * t[i];
            } else {
                level += net * t[i];
                if (level < 0) level = 0;
            }
        }
        return true;
    }
}
