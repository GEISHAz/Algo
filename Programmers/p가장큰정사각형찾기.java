package Programmers;

public class p가장큰정사각형찾기 {
    int[][] dp1, dp2;
    int max = Integer.MIN_VALUE;

    // 가로 dp1, 세로 dp2 배열 생성
    public void createDp(int x, int y, int[][] board) {
        for (int i = 0; i < x; i++) {
            int dsum = 0;  // 가로 합
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 0) {
                    dsum = 0;
                } else {
                    dsum++;
                }
                dp1[i][j] = dsum;
            }
        }

        for (int j = 0; j < y; j++) {
            int psum = 0;  // 세로 합
            for (int i = 0; i < x; i++) {
                if (board[i][j] == 0) {
                    psum = 0;
                } else {
                    psum++;
                }
                dp2[i][j] = psum;
            }
        }
    }

    // DP 체크 메소드
    // 대각선 체크 및 최대 정사각형 크기 계산
    public void dpCheck(int x, int y, int[][] board) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        // 현재 위치에서 가능한 정사각형 크기를 결정
                        int squareSize = Math.min(dp1[i][j-1], Math.min(dp2[i-1][j], dp1[i-1][j-1])) + 1;
                        dp1[i][j] = squareSize;  // dp1에 저장 (세로/가로 교차 결과)
                    } else {
                        dp1[i][j] = 1;  // 경계값 처리
                    }
                    max = Math.max(max, dp1[i][j]);  // 최대 크기 갱신
                }
            }
        }
    }

    public int solution(int [][]board) {
        int x = board.length;
        int y = board[0].length;
        dp1 = new int[x][y];
        dp2 = new int[x][y];
        createDp(x, y, board);
        dpCheck(x, y, board);
        return max * max;  // 면적 계산
    }
}


//class Solution {
//    public int solution(int [][]board) {
//        int n = board.length;
//        int m = board[0].length;
//
//        int[][] dp = new int[n][m];
//        int maxSquareLength = 0;
//
//        // DP 배열 초기화 및 정사각형 계산
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 1) {
//                    // 경계선에 있는 경우에는 자기 자신이 정사각형의 한 변 길이
//                    if (i == 0 || j == 0) {
//                        dp[i][j] = board[i][j];
//                    } else {
//                        // 상단, 좌측, 대각선 상단-좌측 값을 참조
//                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
//                    }
//                    // 가장 큰 정사각형의 한 변의 길이 갱신
//                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
//                }
//            }
//        }
//
//        // 가장 큰 정사각형의 면적 반환
//        return maxSquareLength * maxSquareLength;
//    }
//}
//
