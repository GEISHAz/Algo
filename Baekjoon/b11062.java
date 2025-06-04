import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < T ; t++) {
            sb.append(logic(br)).append('\n');
        }
        System.out.println(sb);
    }

    private static int logic(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[N][N];
        int[] prefix = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
            dp[i][i] = arr[i];
        }

        for (int len = 1; len < N; len++) {
            for (int s = 0; s + len < N; s++) {
                int e = s + len;
                int total = prefix[e + 1] - prefix[s];
                dp[s][e] = Math.max(
                        arr[s] + (total - arr[s] - dp[s + 1][e]),
                        arr[e] + (total - arr[e] - dp[s][e - 1])
                );
            }
        }
        return dp[0][N - 1];
    }
}