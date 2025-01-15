import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1520 {

    static int N,M;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    static int[][] dp; // dp[i][j] 는 [0][0]부터  까지 곱셈중 최소 연산 횟수
    static int[][] value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        value = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],-1);
            for (int j = 0 ; j < M ; j++)
                value[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if(x == N-1 && y == M-1) return 1;
        if(dp[x][y] == -1)
            dp[x][y] = 0;
        for (int d = 0 ; d < 4 ; d ++){
            int dx = x+dir[d][0];
            int dy = y+dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < M  && value[dx][dy] < value[x][y])
            {
                if(dp[dx][dy] != -1)
                    dp[x][y] += dp[dx][dy];
                else
                    dp[x][y] += dfs(dx,dy);
            }
        }
        return dp[x][y];
    }
}