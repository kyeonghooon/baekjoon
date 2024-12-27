package org.example.solv.programmers.lv2;

import java.util.*;

public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int[] curNumber = number.clone();
        int size = want.length;
        int answer = 0;
        int left = 0;
        int length = 10;
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], new int[]{number[i], 0});
        }
        int count = 0;
        for (int right = 0; right < discount.length; right++) {
            String rightStr = discount[right];
            String leftStr = discount[left];
            int curLength = right - left + 1;
            if (map.containsKey(rightStr)) {
                int[] arr = map.get(rightStr);
                arr[1]++;
                if (arr[0] == arr[1]) count++;
            }
            if (curLength > length) {
                left++;
                if (map.containsKey(leftStr)) {
                    int[] arr = map.get(leftStr);
                    if (arr[0] == arr[1]) count--;
                    arr[1]--;
                }
            }
            if (count == size) answer++;
        }
        return answer;
    }
}
