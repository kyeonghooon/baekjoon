package org.example.solv.programmers.practice.lv2;

public class MaxMin {
	
	public static void main(String[] args) {
		
	}
	
	public static String solution(String s) {
        String[] spilt = s.split(" ");
        Integer max = null;
        Integer min = null;
        for (String string : spilt) {
        	int temp = Integer.parseInt(string);
			if (max == null || max < temp) {
				max = temp;
			}
			if (min == null || min > temp) {
				min = temp;
			}
		}
        return min + " " + max;
    }
}
