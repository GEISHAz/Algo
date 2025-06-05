import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            dp[i] = arr[i-1];
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1 ; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
