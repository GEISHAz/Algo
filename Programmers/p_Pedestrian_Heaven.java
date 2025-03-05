package Programmers;

class p_Pedestrian_Heaven {

    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n];  // 오른쪽으로 가는 경우의 수
        int[][] down = new int[m][n];   // 아래쪽으로 가는 경우의 수

        right[0][0] = 1;  // 시작점

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue;  // 통행 불가능한 경우

                // 왼쪽에서 오는 경우 (→ 방향)
                if (j > 0) {
                    if (cityMap[i][j - 1] == 2) right[i][j] = right[i][j - 1];
                    else right[i][j] = (right[i][j - 1] + down[i][j - 1]) % MOD;
                }

                // 위쪽에서 오는 경우 (↓ 방향)
                if (i > 0) {
                    if (cityMap[i - 1][j] == 2) down[i][j] = down[i - 1][j];
                    else down[i][j] = (right[i - 1][j] + down[i - 1][j]) % MOD;
                }
            }
        }

        return (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD;
    }

}
