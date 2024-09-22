package solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N18512 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splits = br.readLine().split(" ");
		int a = Integer.parseInt(splits[0]);
		int b = Integer.parseInt(splits[1]);
		int X = Integer.parseInt(splits[2]);
		int Y = Integer.parseInt(splits[3]);
		
		while (X != Y) {
            if (X < Y) {
                X += a;  // X가 Y보다 작으면 첫 번째 사람이 점프
            } else {
                Y += b;  // Y가 X보다 작으면 두 번째 사람이 점프
            }

            // 너무 큰 값으로 가면 만나지 못한다는 의미이므로 -1을 출력하고 종료
            if (X > 1000000000 || Y > 1000000000) {
                System.out.println(-1);
                return;
            }
        }

        // 두 사람이 만나는 지점 출력
        System.out.println(X);
	}
}
