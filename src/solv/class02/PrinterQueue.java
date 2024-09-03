package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PrinterQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] priority; 
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			priority = new int[10];
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine());
			Deque<int[]> deque = new ArrayDeque<>();
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(token.nextToken());
				priority[num]++;
				deque.addLast(new int[]{num, j});
			}
			while (!deque.isEmpty()) {
                int[] current = deque.pollFirst();
                boolean isPrintable = true;
                for (int j = 9; j > current[0]; j--) {
                    if (priority[j] > 0) {
                        isPrintable = false;
                        break;
                    }
                }
                if (isPrintable) {
                    priority[current[0]]--;
                    if (current[1] == M) {
                        sb.append(N - deque.size()).append("\n");
                        break;
                    }
                } else {
                    deque.addLast(current);
                }
            }
		}
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
