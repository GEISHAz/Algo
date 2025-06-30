import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2133 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N%2 ==1) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 3;
        for(int i = 4; i <= N ; i+=2){
            dp[i] = dp[i-2] * 3 + 2;
            for(int j = 0 ; j < i-2 ; j+=2){
                dp[i]+= dp[j]*2;
            }
        }
        System.out.println(dp[N]);
    }
}
