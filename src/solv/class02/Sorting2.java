package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Sorting2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		for (Integer integer : set) {
			bw.write(integer + "\n");
		}
		bw.flush();
		bw.close();
	}

}
