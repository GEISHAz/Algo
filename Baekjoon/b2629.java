import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2629 {

    static int N,M;
    static int[] beads,weights;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        logic();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++) {
            if (beads[i] > 15000) sb.append("N ");
            else if(dp[N-1][beads[i]]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }

    private static void logic() {
        Arrays.sort(weights);
        dp[0][weights[0]]= true;
        for (int i = 1; i < N; i++) { //구슬 종류
            dp[i][weights[i]]= true;
            for(int j = 0 ; j < 15001; j++) { // 이전 무게 위치
                if(dp[i-1][j]) {
                    dp[i][j] = true;
                    int sum = Math.abs(j + weights[i]);
                    dp[i][Math.abs(j - weights[i])] = true;
                    if (sum <= 15000)
                        dp[i][sum] = true;
                }
            }
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            weights[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        beads = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            beads[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[N][15001];
    }
}