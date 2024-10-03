package Programmers;
// DP
// 1번째 스티커를 선택할때 끝 스티커를 선택하지 못하게
// 마지막 스티커를 선택할때 끝 스티커를 선택할 수 있게
import java.util.*;

class p스티커모으기 {
	public int solution(int sticker[]) {
		int n = sticker.length;
		// 스티커가 1개인 경우 바로 리턴
		if (n == 1) return sticker[0];

		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		// dp1 초기화: 첫 번째 스티커를 선택했으므로 dp1[0]에 첫 번째 값이 들어감
		dp1[0] = sticker[0];
		dp1[1] = Math.max(sticker[0], sticker[1]);
		// dp2 초기화: 첫 번째 스티커를 선택하지 않으므로 dp2[0]은 0, dp2[1]은 두 번째 값
		dp2[0] = 0;
		dp2[1] = sticker[1];
		// dp1과 dp2 배열 계산 (두 번째 스티커부터)
		for (int i = 2; i < n - 1; i++)
			dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
		// dp2는 마지막 스티커 선택 가능
		for (int i = 2; i < n; i++)
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
		return Math.max(dp1[n-2], dp2[n-1]);
	}
}
