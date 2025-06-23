import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 0;

        for(int i = 0 ; i < N ; i++){
            dp[i] = input[i];
            for(int j = 0 ; j < i ; j++){
                if(input[j]<input[i])
                    dp[i] = Math.max(dp[i], dp[j]+input[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}