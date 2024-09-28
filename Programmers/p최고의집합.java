package Programmers;
// 일단 s 를 n 으로 나눈다.
// 그럼 하나의 숫자가 나오게 되어있다.

class p최고의집합 {
	public int[] solution(int n, int s) {
		int[] answer = new int[n];
		int num = s / n;

		if (num < 1) {
			return new int[]{-1}; // 바로 -1을 반환하는 배열 생성
		} else {
			int remainder = s % n; // d를 계산하는 대신 나머지를 직접 사용
			for (int i = 0; i < n; i++) {
				if (n - i <= remainder) {
					answer[i] = num + 1;
				} else {
					answer[i] = num;
				}
			}
			// 결과가 이미 정렬되어 있으므로 Collections.sort 호출 제거
			return answer;
		}
	}
}