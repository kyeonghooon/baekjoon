package org.example.solv.marathon.course044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrayArea {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (n == 0 && w == 0) break;
            int[] arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(br.readLine());
                arr[i] = cur;
                if (arr[i] > max) max = arr[i];
            }
            int length = max / w;
            int[] counts = new int[length + 1];
            double maxCount = 0;
            for (int i = 0; i < n; i++) {
                counts[arr[i] / w]++;
                maxCount = Math.max(maxCount, counts[arr[i] / w]);
            }
            double sum = 0.01;
            for (int i = 0; i < counts.length; i++) {
                double numerator = length - i;
                sum += (numerator / length) * (counts[i] / maxCount);
            }
            sb.append(sum).append("\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
