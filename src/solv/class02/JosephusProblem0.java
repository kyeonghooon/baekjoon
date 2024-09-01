package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JosephusProblem0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> linkedList = new LinkedList<>();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		for (int i = 1; i <= N; i++) {
			linkedList.add(i);
		}
		int idx = K - 1;
		sb.append("<");
		while (true) {
			sb.append(linkedList.remove(idx));
			if (linkedList.isEmpty()) {
				sb.append(">");
				break;
			} else {
				idx = (idx + K - 1) % linkedList.size();
				sb.append(", ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
