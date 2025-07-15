import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14916 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //i 원일때 최소 동전 갯수
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        dp[5] = 1;

        if(N > 5) {
            for (int i = 6; i <= N; i++) {
                dp[i] = Math.min( dp[i-5] , dp[i-2] ) + 1;
            }
        }
        System.out.println((dp[N]==Integer.MAX_VALUE)?-1:dp[N]);
    }
}