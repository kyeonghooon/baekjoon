package org.example.solv;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
    }

    public int solution(String[] babbling) {
        int answer = 0;
        String[] corrects = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            for (int j = 0; j < 4; j++) {
                if (str.contains(corrects[j])) {
                    str = str.replace(corrects[j], ",");
                }
            }
            if (str.replace(",", "").length() == 0) {
                answer++;
            }
        }
        return answer;
    }

}
