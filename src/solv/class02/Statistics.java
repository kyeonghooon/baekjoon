package solv.class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = Integer.parseInt(br.readLine());
		int[] list = new int[count];
		int[] countList = new int[8001];
		int sum = 0;
		for (int i = 0; i < count; i++) {
			list[i] = Integer.parseInt(br.readLine());
			sum += list[i];
			countList[list[i] + 4000]++;
		}
		int avg = (int)Math.round((double)sum / count);
		Arrays.sort(list);
		sb.append(avg + "\n").append(list[count / 2] + "\n");
		int max = 0;
		for (int i = 0; i < countList.length; i++) {
			max = Math.max(countList[i], max);
		}
		boolean flag = false;
		int mode = 0;
		for (int i = 0; i < countList.length; i++) {
			if (max == countList[i]) {
				mode = i - 4000;
				if (flag) {
					break;
				} else {
					flag = true;
				}
			}
		}
		sb.append(mode + "\n");
		sb.append(list[list.length - 1] - list[0] + "\n");
		System.out.println(sb);
	}

}
