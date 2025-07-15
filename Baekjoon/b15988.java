import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15988 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[1_000_001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            dp[i] = logic(dp[i-1]+dp[i-2]+dp[i-3]);
        }
        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
    private static long logic(long n){
        return n%1000000009;
    }
}