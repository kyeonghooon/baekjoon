package org.example.solv.programmers.practice.lv2;

import java.util.*;

public class NextBigNumber {

    public static void main(String[] args) {
        int[] arr = new NextBigNumber().solution(new int[]{2, 3, 3, 5});
        System.out.println(Arrays.toString(arr));
    }

    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
