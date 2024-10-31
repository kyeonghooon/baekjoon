package org.example.solv.marathon.course022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9307 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] candies = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int candy = Integer.parseInt(st.nextToken());
                candies[i] = candy % 2 == 0 ? candy : candy + 1; // 홀수면 짝수로 보충
            }

            int count = 0;
            while (!allEqual(candies)) {
                int[] halfCandies = new int[N];

                // 각 아이가 가진 사탕의 절반을 저장
                for (int i = 0; i < N; i++) {
                    halfCandies[i] = candies[i] / 2;
                    candies[i] -= halfCandies[i];
                }

                // 오른쪽 아이에게 사탕 절반을 전달
                for (int i = 0; i < N; i++) {
                    candies[(i + 1) % N] += halfCandies[i];
                }

                // 짝수로 보충
                for (int i = 0; i < N; i++) {
                    if (candies[i] % 2 != 0) {
                        candies[i]++;
                    }
                }

                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    // 모든 아이의 사탕 개수가 같은지 확인하는 함수
    private static boolean allEqual(int[] candies) {
        for (int candy : candies) {
            if (candy != candies[0]) {
                return false;
            }
        }
        return true;
    }
}
