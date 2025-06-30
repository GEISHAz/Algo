import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11722 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}