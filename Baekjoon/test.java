import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static int N, bMax, wMax;
    public static int[][] map;

    public static int[] dx = {-1, 1, -1, 1};
    public static int[] dy = {-1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new boolean[N][N], 0, 0, 0, true);
        dfs(new boolean[N][N], 0, 1, 0, false);

        System.out.println(bMax + wMax);
    }

    public static void dfs(boolean[][] now, int y, int x, int cnt, boolean isBlack) {
        if (isBlack) {
            bMax = Math.max(cnt, bMax);
        } else {
            wMax = Math.max(cnt, wMax);
        }

        if (x >= N) {
            y += 1;
            x = (y % 2 == 0) ? (isBlack ? 0 : 1) : (isBlack ? 1 : 0);
        }

        if (y >= N) return;

        if (check(now, y, x)) {
            now[y][x] = true;
            dfs(now, y, x + 2, cnt + 1, isBlack);
            now[y][x] = false;
        }

        dfs(now, y, x + 2, cnt, isBlack);
    }

    public static boolean check(boolean[][] now, int y, int x) {
        if (map[y][x] == 0) return false;

        for (int i = 0; i < 4; i++) {
            int yy = y, xx = x;

            while (true) {
                yy += dy[i];
                xx += dx[i];
                if (yy < 0 || xx < 0 || yy >= N || xx >= N) break;
                if (now[yy][xx]) return false;
            }
        }
        return true;
    }
}
