package Programmers;
//투포인터 쓰자.
// 둘다 정렬해
// index a b 변수선언하고
// index a 보다 b가 크면 둘다 +1 하고 answer+1
// index a 보다 b가 작으면 b만 +1 
// b가 B.length 될때까지 ㅇㅇ
import java.util.*;

class p숫자게임 {
	public int solution(int[] A, int[] B) {
		int answer = 0, a = 0, b = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		while(B.length > b){
			if(A[a] < B[b]){
				a++;
				b++;
				answer++;
			} else b++;
		}
		return answer;
	}
}