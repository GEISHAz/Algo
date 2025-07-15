import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1937 {

    static int N, ans;
    static int[][] dp, arr;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // arr[i][j] 를 기준으로 DFS 후 결과 dp에저장
                dp[i][j] = dfs(i, j);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int i, int j) {
        // 이미 계산된 값이 있다면 그대로 반환
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // 어떤 경로도 선택하지 않아도 자기 자신을 포함하므로 최소 길이는 1
        dp[i][j] = 1;

        for (int d = 0; d < 4; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];

            if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] > arr[i][j]) {
                // (i,j)에서 시작하는 경로 길이 = 1 + (다음 위치에서 시작하는 경로 길이)
                dp[i][j] = Math.max(dp[i][j], dfs(x, y) + 1);
            }
        }

        return dp[i][j];
    }
}