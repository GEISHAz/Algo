package Programmers;

import java.util.*;

class p줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> strarr = new ArrayList<>();

        //팩토리얼 값
        long f = 1;

        for(int i = 1 ; i <= n ; i++){
            strarr.add(i);
            f *= i;  //전체 경우의 수 팩토리얼 계산
        }

        //각 answer의 들어가야할 idx 번호
        int idx = 0;

        //answer arr는 0 부터 시작하여 1번째가 된다.
        k--;

        while(idx < n){
            f = f / (n - idx);  // f에서 몇번째 위치에 무슨 숫자가 들어가야하는지 검사
            answer[idx++] = strarr.remove((int) (k / f));
            k %= f; // 숫자가 들어갔으니 k 최신화
        }
        return answer;
    }
}