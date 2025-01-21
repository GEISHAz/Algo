import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2293 {

    static int N, K;
    static int[][] dp;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
        logic();
        System.out.println(dp[N-1][K]);
    }

    private static void logic() {
        dp = new int[N][K+1];

        for (int i = 0; i <= K; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
    }
}
