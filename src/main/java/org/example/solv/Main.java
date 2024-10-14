package org.example.solv;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		int[][] field = new int[][]{{0,1,0,1},{0,0,0,1},{1,1,1,0},{0,1,1,1}};
		int[][] mines = new int[4][4];

		int w = 4, h = 4;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (field[y][x] == 0) continue;
				for (int i = y - 1; i <= y + 1; i++) {
					for (int j = x - 1; j <= x + 1; j++) {
						if (calculate(w,h,j,i) == 1){
							mines[i][j] += 1;
						}
					}
				}
			}
		}
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				System.out.print(mines[y][x] + " ");
			}
			System.out.println();
		}
	}
	static int calculate (int w, int h, int j, int i) {
		if (i >= 0 && i < h && j >= 0 && j < w) return 1;
		return 0;
	}
}
