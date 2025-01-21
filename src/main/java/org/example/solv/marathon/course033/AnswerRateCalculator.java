package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AnswerRateCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Map<String, int[]> map = new HashMap<>();
        double success = 0;
        double fail = 0;
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            String username = splits[1];
            int result = Integer.parseInt(splits[2]);
            if (username.equals("megalusion")) continue;
            int[] arr = map.getOrDefault(username, new int[2]);
            if (arr[0] > 0) continue;
            if (result == 4) {
                success++;
                arr[0]++;
                map.put(username, arr);
            } else {
                fail++;
                arr[1]++;
                map.put(username, arr);
            }
        }
        for (int[] arr : map.values()) {
            if (arr[0] > 0) continue;
            fail -= arr[1];
        }
        double answer = success == 0 ? 0 : (success / (success + fail)) * 100;
        System.out.println(answer);
    }

}
