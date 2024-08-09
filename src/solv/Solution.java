package solv;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) {
		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		System.out.println(new Solution().solution(friends, gifts)); 
	}

	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		Map<String, Integer> sendCount = new HashMap<>();
		Map<String, Integer> receiveCount = new HashMap<>();
		Map<String, Integer> factor = new HashMap<>();
		Map<String, Integer> result = new HashMap<>();
		for (String gift : gifts) {
			StringTokenizer tokenizer = new StringTokenizer(gift);
			String sender = tokenizer.nextToken();
			String receiver = tokenizer.nextToken();
			sendCount.put(sender, sendCount.getOrDefault(sender, 0) + 1);
			receiveCount.put(receiver, receiveCount.getOrDefault(receiver, 0) + 1);
		}
		for (String friend : friends) {
			int send = sendCount.getOrDefault(friend, 0);
			int receive = receiveCount.getOrDefault(friend, 0);
			factor.put(friend, send - receive);
		}
		for (int i = 0; i < friends.length - 1; i++) {
			for (int j = i; j < friends.length; j++) {
				String A = friends[i];
				String B = friends[j];
				String AtoB = A + " " + B;
				int AtoBCount = 0;
				String BtoA = B + " " + A;
				int BtoACount = 0;
				for (String string : gifts) {
					if (string.equals(AtoB)) {
						AtoBCount++;
					}
					if (string.equals(BtoA)) {
						BtoACount++;
					}
				}
				if (AtoBCount > BtoACount) {
					result.put(A, result.getOrDefault(A, 0) + 1);
				} else if (AtoBCount < BtoACount) {
					result.put(B, result.getOrDefault(B, 0) + 1);
				} else {
					if (factor.get(A) > factor.get(B)) {
						result.put(A, result.getOrDefault(A, 0) + 1);
					} else if (factor.get(A) < factor.get(B)) {
						result.put(B, result.getOrDefault(B, 0) + 1);
					}
				}
			}
		}
		for (String friend : result.keySet()) {
			int temp = result.getOrDefault(friend, 0);
			if (temp > answer) {
				answer = temp;
			}
		}
		return answer;
	}
}
