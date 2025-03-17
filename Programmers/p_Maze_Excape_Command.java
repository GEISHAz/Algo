package Programmers;

class p_Maze_Excape_Command{

    int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};  // d, l, r, u 순
    char[] moveChar = {'d', 'l', 'r', 'u'};
    int K, N, M;
    String answer;  // 가장 빠른 경로 저장

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        char[] route = new char[k];
        K = k;
        N = n;
        M = m;
        answer = null;  // 아직 정답이 없음

        int minStep = Math.abs(x - r) + Math.abs(y - c);
        if (minStep > K || (K - minStep) % 2 != 0)
            return "impossible";

        DFS(x, y, r, c, 0, route);

        return answer == null ? "impossible" : answer;
    }

    private boolean DFS(int sx, int sy, int r, int c, int depth, char[] route) {
        if (answer != null) return true;  // 이미 정답을 찾았으면 더 이상 탐색 X

        if (depth + Math.abs(sx - r) + Math.abs(sy - c) > K) return false;  // 백트래킹 (도착 불가능하면 중단)

        if (depth == K) {
            if (sx == r && sy == c) {
                answer = new String(route);  // 가장 빠른 경로 저장
                return true;  // 정답 찾았으므로 종료
            }
            return false;
        }

        for (int d = 0; d < 4; d++) {
            int nowX = sx + dir[d][0];
            int nowY = sy + dir[d][1];

            if (nowX < 1 || nowX > N || nowY < 1 || nowY > M)
                continue;

            route[depth] = moveChar[d];
            if (DFS(nowX, nowY, r, c, depth + 1, route)) return true;  // 정답을 찾았으면 종료
        }
        return false;
    }
}