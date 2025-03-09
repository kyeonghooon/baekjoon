package org.example.solv.programmers.stack_queue.lv2;

import java.util.Stack;

public class StockPrice {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < size; i++) {
            answer[i] = size - 1 - i;
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}
