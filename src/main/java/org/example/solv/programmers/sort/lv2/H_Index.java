package org.example.solv.programmers.sort.lv2;

public class H_Index {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;
        for (int i = n; i > 0; i--) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < n; j++) {
                if (citations[j] >= i) count1++;
            }
            if (count1 >= i) return i;
        }
        return answer;
    }
}
