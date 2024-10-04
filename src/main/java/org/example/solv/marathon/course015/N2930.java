package org.example.solv.marathon.course015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2930 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(br.readLine());
		char[] player = new char[R + 1];
		String playerStr = br.readLine();
		for (int i = 0; i < playerStr.length(); i++) {
			player[i] = playerStr.charAt(i);
		}
		int N = Integer.parseInt(br.readLine());
		String[] RList = new String[R + 1];
		for (int i = 0; i < N; i++) {
			String opponentStr = br.readLine();
			for (int j = 0; j < opponentStr.length(); j++) {
				RList[j] += opponentStr.charAt(j);
			}
		}
		int currentScore = 0;
		int MaxScore = 0;
		for (int i = 0; i < R; i++) {
			int sScore = 0;
			int pScore = 0;
			int rScore = 0;
			for (int j = 0; j < RList[i].length(); j++) {
				currentScore += getScore(player[i], RList[i].charAt(j));
				sScore += getScore('S', RList[i].charAt(j));
				pScore += getScore('P', RList[i].charAt(j));
				rScore += getScore('R', RList[i].charAt(j));
			}
			MaxScore += Math.max(Math.max(sScore, pScore), rScore);
		}
		sb.append(currentScore).append("\n").append(MaxScore);
		System.out.println(sb);
	}

	public static int getScore(char player, char opponent) {
		switch (player) {
		case 'S':
			switch (opponent) {
			case 'P':
				return 2;
			case 'R':
				return 0;
			case 'S':
				return 1;
			}
		case 'P':
			switch (opponent) {
			case 'R':
				return 2;
			case 'S':
				return 0;
			case 'P':
				return 1;
			}
		case 'R':
			switch (opponent) {
			case 'S':
				return 2;
			case 'P':
				return 0;
			case 'R':
				return 1;
			}
		default:
			return 0;
		}
	}
}
