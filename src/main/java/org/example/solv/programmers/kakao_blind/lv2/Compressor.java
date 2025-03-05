package org.example.solv.programmers.kakao_blind.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compressor {

    public static void main(String[] args) {
        int[] arr = new Compressor().solution("ABABABABABABABAB");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char) i), idx++);
        }
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int curNum = 0;
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (map.containsKey(sb.toString())) {
                    curNum = map.get(sb.toString());
                    i++;
                    if (j == msg.length() - 1) list.add(curNum);
                } else {
                    list.add(curNum);
                    map.put(sb.toString(), idx++);
                    i--;
                    break;
                }
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
