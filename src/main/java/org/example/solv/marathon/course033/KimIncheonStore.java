package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KimIncheonStore {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        while (T-- > 0) {
            sb.append("Case #").append(++count).append(":");
            int N = Integer.parseInt(br.readLine());
            String[] splits = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>(Arrays.stream(splits)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                if (n % 3 == 0 && list.contains((n / 3) * 4)) {
                    list.remove(Integer.valueOf((n / 3) * 4));
                    sb.append(" ").append(n);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
