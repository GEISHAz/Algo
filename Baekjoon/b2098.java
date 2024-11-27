import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2098 {

    static int N, INF = Integer.MAX_VALUE/2;
    static int[][] dist,dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set(br);
        System.out.println(tsp());

    }

    private static int tsp() {
        int answer = INF;

        for (int visited = 0 ; visited < (1<<N) ; visited++){
            for (int current = 0 ; current < N ; current++){
                if((visited & (1 << current)) == 0) continue;
                for (int next = 0 ; next < N ; next++){
                    if(current == next) continue;
                    if((visited & (1 << next)) != 0 || dist[current][next] == INF) continue;
                    int nextVisited = (visited|(1<<next));
                    dp[nextVisited][next] = Math.min(
                            dp[nextVisited][next]
                            ,dp[visited][current]+dist[current][next]);
                }
            }
        }

        for (int now = 1 ; now < N ; now++){
            if(dist[now][0] == INF) continue;
            answer = Math.min(answer, dp[(1<<N)-1][now]+dist[now][0]);
        }

        return answer;
    }

    private static void set(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        dp = new int[1<<N][N];

        for(int i = 0 ; i < N ; i++){
            dist[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(s-> s.equals("0") ? INF : Integer.parseInt(s))
                    .toArray();
        }

        for(int[] arr : dp)
            Arrays.fill(arr,INF);

        dp[1][0] = 0;
    }
}


