package Programmers;
// 다이아, 철, 돌 곡괭이 순으로
// 곡괭이는 5회사용가능하며 한번선택시 부러질때까지 사용
// 광물은 순서대로 캐야한다. 무조건 순서를 지킨다.

// 주어진 곡괭이로 가능한 조합을 생성한다
// 예를들어 곡괭이 다 철 돌 순으로 1개씩 보유시
// 다 철 돌
// 다 돌 철
// 철 다 돌
// 철 돌 다
// 돌 철 다
// 돌 다 철
// 6가지 경우의 수가 생성된다.

// 다 다 돌 이면
// 다 돌 다
// 돌 다 다

// 다 다 철 철 이면
// 다 철 다 철
// 다 철 철 다
// 철 다 철 다
// 철 다 다 철
// 철 철 다 다

// 광물의 숫자는 50 이하

// 조합 method
// 조합 들고 검사 method (최신화, 계산)
import java.util.*;

class p광물캐기 {
	int min = Integer.MAX_VALUE;
	List<int[]> list = new ArrayList<>();

	// 곡괭이의 조합을 구하는 함수
	private void combination(int[] count, int depth, int endDepth, int[] com){ // DFS를 이용한 조합 생성
		if(depth == endDepth){ // 조합이 완성되었을 때
			list.add(com.clone()); // 조합을 리스트에 추가
			return;
		}
		for(int i = 0; i < 3; i++){
			if(count[i] > 0){ // 해당 곡괭이가 남아있으면
				count[i]--;
				com[depth] = i; // 해당 곡괭이를 사용
				combination(count, depth + 1, endDepth, com); // 다음 깊이로 이동
				count[i]++; // 백트래킹
			}
		}
	}

	// 조합에 따라 피로도를 계산하는 함수
	private void checkCom(String[] minerals){
		for(int[] arr : list){ // 구해진 모든 곡괭이 조합에 대해
			int sum = 0;
			int idx = 0;
			outerLoop: for(int num : arr){ // 각 곡괭이 종류에 대해
				for(int i = 0; i < 5; i++){ // 곡괭이 하나로 5개의 광물을 캠
					if(idx >= minerals.length) break outerLoop; // 더 이상 캘 광물이 없으면 종료
					String s = minerals[idx++];
					// 각 곡괭이에 따른 피로도 계산
					if(num == 0) sum += 1; // 다이아 곡괭이
					else if(num == 1) sum += s.equals("diamond") ? 5 : 1; // 철 곡괭이
					else if(num == 2) sum += s.equals("diamond") ? 25 : s.equals("iron") ? 5 : 1; // 돌 곡괭이
				}
			}
			min = Math.min(min, sum); // 최소 피로도를 구함
		}
	}

	public int solution(int[] picks, String[] minerals) {
		int totalCount = Arrays.stream(picks).sum(); // 사용할 수 있는 곡괭이의 총 수
		combination(picks.clone(), 0, totalCount, new int[totalCount]); // 곡괭이 조합을 구함
		checkCom(minerals); // 각 조합에 따른 피로도를 계산
		return min; // 최소 피로도를 반환
	}
}