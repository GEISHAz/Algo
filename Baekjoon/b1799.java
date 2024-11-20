import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1799 {
    private static int N, bMax, wMax;
    private static int[][] map;

    private static int[] dx = {-1, 1, -1, 1};
    private static int[] dy = {-1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        bMax = 0;
        wMax = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new boolean[N][N], 0, 0, 0, true); // 흑색 탐색
        dfs(new boolean[N][N], 1, 0, 0, false); // 백색 탐색

        System.out.println(bMax + wMax);
    }

    private static void dfs(boolean[][] visited, int x, int y, int sum, boolean isBlack) {
        if (isBlack) {
            bMax = Math.max(bMax, sum);
        } else {
            wMax = Math.max(wMax, sum);
        }

        if (x >= N) {
            y += 1;
            x = (y % 2 == 0) ? (isBlack ? 0 : 1) : (isBlack ? 1 : 0);
        }

        if (y >= N) return;

        if (check(visited, y, x)) {
            visited[y][x] = true;
            dfs(visited, x + 2, y, sum + 1, isBlack); // 비숍을 놓는 경우
            visited[y][x] = false;
        }
        dfs(visited, x + 2, y, sum, isBlack); // 비숍을 놓지 않는 경우
    }

    private static boolean check(boolean[][] visited, int y, int x) {
        if (map[y][x] == 0) return false; // 비숍을 놓을 수 없는 자리

        for (int i = 0; i < 4; i++) {
            int yy = y, xx = x;

            while (true) { // 대각선 끝까지 탐색
                yy += dy[i];
                xx += dx[i];

                if (yy < 0 || xx < 0 || yy >= N || xx >= N) break;
                if (visited[yy][xx]) return false;
            }
        }
        return true;
    }
}
