import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11049 {

    static int N;
    static int[] input;
    static int[][] dp; // [i][j] 는 i부터 j 까지 곱셈중 최소 연산 횟수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0)
                input[0] = Integer.parseInt(st.nextToken());
            else
                st.nextToken();
            input[i + 1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < N - i + 1; j++) {
                dp[j][j + i - 1] = Integer.MAX_VALUE;
                for (int k = j; k < j + i - 1; k++) {
                    int result = dp[j][k] + dp[k + 1][j + i - 1] + (input[j] * input[k + 1] * input[j + i]);
                    dp[j][j + i - 1] = Math.min(result, dp[j][j + i - 1]);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }

    private static void init() {
        input = new int[N + 1];
        dp = new int[N][N];
    }
}