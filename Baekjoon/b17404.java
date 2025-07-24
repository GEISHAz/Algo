import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17404 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        int[][] input = new int[N][3];

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int t = 0 ; t < 3 ; t++) {

            int[][] dp = new int[N][3];

            for(int i = 0 ; i < 3 ; i++) {
                if( t == i)
                    dp[0][i] = input[0][t];
                else
                    dp[0][i] = 1000000;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = input[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = input[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = input[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            for(int i = 0 ; i < 3 ; i++){
                if(t != i){
                    answer = Math.min(answer, dp[N - 1][i]);
                }
            }
        }

        System.out.println(answer);
    }
}