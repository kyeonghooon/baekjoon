package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCard2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
        int[] cardCount = new int[20000001];
        
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(token.nextToken()) + 10000000;
            cardCount[n]++;
        }
        
        count = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(token.nextToken()) + 10000000;
            sb.append(cardCount[n]).append(" ");
        }
        
        System.out.println(sb);
	}

}
