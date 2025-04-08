package Programmers;

import java.util.Arrays;
import java.util.*;

class p_Muzzis_eating_live_show {
	class Node {
		int number;
		int times;
		public Node(int number, int times){
			this.number = number;
			this.times = times;
		}
	}

	public int solution(int[] food_times, long k) {
		int n = food_times.length;
		Node[] foods = new Node[n];

		for (int i = 0; i < n; i++) {
			foods[i] = new Node(i + 1, food_times[i]);  // 문제는 1-based index
		}

		// 시간 기준 정렬 (가장 적게 걸리는 음식부터)
		Arrays.sort(foods, (a, b) -> {
			if (a.times == b.times) return a.number - b.number;
			return a.times - b.times;
		});

		long totalTime = 0; // 지금까지 누적 제거한 시간
		int prevTime = 0;   // 이전까지 제거한 레벨의 시간
		int i = 0;          // 현재 foods 인덱스

		for (; i < n; i++) {
			long timeDiff = foods[i].times - prevTime;
			if (timeDiff != 0) {
				long spend = timeDiff * (n - i); // 현재 남은 음식 수 × 시간 차이

				if (spend <= k) {
					k -= spend;
					totalTime += timeDiff;
					prevTime = foods[i].times;
				} else {
					break;
				}
			}
		}

		// i부터 끝까지가 남은 음식들
		if (i == n) return -1; // 전부 먹었으면

		// 남은 음식들 번호 순 정렬
		List<Node> remaining = new ArrayList<>();
		for (int j = i; j < n; j++) {
			remaining.add(foods[j]);
		}
		remaining.sort(Comparator.comparingInt(a -> a.number));

		return remaining.get((int)(k % remaining.size())).number;
	}
}