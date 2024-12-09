import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1562 {

    static int n, MOD = 1000000000;
    static long[][][] dp ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n][10][1024];

        for(int i = 1 ; i <= 9 ; i++){
            dp[0][i][1<<i] = 1;
        }

        for(int i = 1; i < n ; i++){
            for(int j = 0 ; j < 10 ; j++){
                for(int k = 0 ; k < 1024; k++){
                    int bit = k | (1 << j);
                    if(j == 0){
                        dp[i][j][bit] = (dp[i-1][j+1][k] + dp[i][j][bit])%MOD ;
                    }
                    else if(j == 9){
                        dp[i][j][bit] = (dp[i-1][j-1][k] + dp[i][j][bit])%MOD ;
                    }
                    else{
                        dp[i][j][bit] = (dp[i-1][j+1][k] + dp[i-1][j-1][k] + dp[i][j][bit]) % MOD ;
                    }
                }
            }
        }

        long answer = 0;
        for(int i = 0 ; i < 10 ; i++){
            answer += dp[n-1][i][1023];
            answer %= MOD;
        }
        System.out.println(answer);
    }
}
