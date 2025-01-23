package org.example.solv.programmers.kakao_blind.lv2;

import java.util.HashMap;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> frequency1 = new HashMap<>();
        HashMap<String, Integer> frequency2 = new HashMap<>();
        for (int i = 1; i < str1.length(); i++) {
            String element = "" + str1.charAt(i - 1) + str1.charAt(i);
            if (element.matches("[A-Za-z]+")) {
                element = element.toLowerCase();
                frequency1.put(element, frequency1.getOrDefault(element, 0) + 1);
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            String element = "" + str2.charAt(i - 1) + str2.charAt(i);
            if (element.matches("[A-Za-z]+")) {
                element = element.toLowerCase();
                frequency2.put(element, frequency2.getOrDefault(element, 0) + 1);
            }
        }
        if (frequency1.size() == 0 && frequency2.size() == 0) {
            return 65536;
        }
        double intersection = 0;
        double union = 0;
        for (String e : frequency1.keySet()) {
            int a = frequency1.get(e);
            int b = frequency2.getOrDefault(e, 0);
            intersection += Math.min(a, b);
            union += Math.max(a, b);
            frequency2.remove(e);
        }
        for (int n : frequency2.values()) {
            union += n;
        }
        answer = (int)(intersection / union * 65536);
        return answer;
    }
}
