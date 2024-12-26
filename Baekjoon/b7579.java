import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b7579 {
    static int N,M,mininumAnswer=Integer.MAX_VALUE;
    static int[] m,c;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 실행되고 있는 앱수
        M = Integer.parseInt(st.nextToken()); // 필요한 메모리수
        m = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        c = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        dp = new int[N][10001];

        //첫 원소를 포함하는 경우의 수 ~ 마지막원소를 포함하는 경우의수
        for(int i = 0 ; i < N ; i++) {
            int cost = c[i];
            int memory = m[i];
            for (int j = 0; j < 10001; j++) {
                if (i == 0){
                    if (j >= cost) dp[i][j] = memory;
                }else{
                    if (j >= cost){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cost]+memory);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][j] > M){
                    mininumAnswer = Math.min(mininumAnswer,j);
                }
            }
        }
        System.out.println(mininumAnswer);
    }
}
