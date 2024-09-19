package Programmers;

import java.util.*;

class p정수삼각형 {
    public int solution(int[][] triangle) {
        // DP 배열을 삼각형의 마지막 행 크기로 초기화
        int[] DP = new int[triangle[triangle.length - 1].length];
        // 맨 마지막 행을 먼저 DP에 복사
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            DP[i] = triangle[triangle.length - 1][i];
        }
        // 아래에서 위로 DP 계산
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 현재 위치에서 아래층의 두 값 중 큰 값 더하기
                DP[j] = triangle[i][j] + Math.max(DP[j], DP[j + 1]);
            }
        }
        // 최종적으로 DP[0]에는 최대 경로 합이 저장됨
        return DP[0];
    }
}
