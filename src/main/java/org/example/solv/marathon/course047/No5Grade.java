package org.example.solv.marathon.course047;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No5Grade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] subjects = new int[10][2];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i][0] = Integer.parseInt(st.nextToken());
            subjects[i][1] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        while (N++ < 8) {
            int count = 0;
            while (subjects[idx][0] > 0 && A < 66 && count < 6) {
                subjects[idx][0]--;
                A += 3;
                B += 3;
                count++;
            }
            while (subjects[idx][1] > 0 && B < 130 && count < 6) {
                subjects[idx][1]--;
                B += 3;
                count++;
            }
            idx++;
        }
        if (isGrade(A, B)) {
            System.out.println("Nice");
        } else {
            System.out.println("Nae ga wae");
        }
    }

    public static boolean isGrade(int a, int b) {
        return a >= 66 && b >= 130;
    }
}
