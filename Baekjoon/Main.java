import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            dp[i] = dp[logic(i)]+1;
        }
        System.out.println(dp[N]);
    }
    private static int logic(int n){
        if(dp[n] != Integer.MAX_VALUE) return dp[n];
        int answer = Integer.MAX_VALUE;
        for(int i = 1 ; Math.pow(i,2) <= n ; i++){
            answer = Math.min(answer,logic((int)(n-Math.pow(i,2))));
        }
        return answer;
    }
}
