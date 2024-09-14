package solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MakeOne {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[1000001];
		queue.add(new int[] {n, 0});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if (current[0] == 1) {
				System.out.println(current[1]);
				break;
			}
			
			if (current[0] % 3 == 0 && !visit[current[0] / 3]) {
				queue.add(new int[]{current[0] / 3, current[1] + 1});
				visit[current[0] / 3] = true;
			}
			
			if (current[0] % 2 == 0 && !visit[current[0] / 2]) {
				queue.add(new int[]{current[0] / 2, current[1] + 1});
				visit[current[0] / 2] = true;
			}
			
			if (!visit[current[0] - 1]) {
				queue.add(new int[]{current[0] - 1, current[1] + 1});
				visit[current[0] - 1] = true;
			}
		}
	}
	
}
