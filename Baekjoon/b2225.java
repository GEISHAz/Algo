import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2225 {

    static int N, M;
    static int[][] dp; // i까지의 정수 j개를 더해서 그합이 i 되는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M+1];
        for(int i = 1 ; i <= M ; i++){
            dp[1][i] = i;
        }
        for(int i = 1 ; i <= N ; i++){
            dp[i][1] = 1;
        }

        for(int i = 2; i <= M ; i++){
            for(int j = 2 ; j <= N ; j++){
                dp[j][i] = (dp[j-1][i] + dp[j][i-1])%1000000000;
            }
        }
        System.out.println(dp[N][M]);
    }
}