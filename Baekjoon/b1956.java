import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1956 {

    static int V,E;
    static int INF = 40000000;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stringToInt(st.nextToken());
        E = stringToInt(st.nextToken());

        graph = new int[V+1][V+1];
        for(int i = 0; i <= V; i++)
            Arrays.fill(graph[i], INF);

        for(int i = 0; i <= V; i++)
            graph[i][i] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stringToInt(st.nextToken());
            int b = stringToInt(st.nextToken());
            int c = stringToInt(st.nextToken());

            graph[a][b] = c;
        }               //input End

        logic();

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, graph[i][i]);
        }
        System.out.println((answer==INF)? -1 : answer);
    }

    static void logic() { // floyd-warshall
        for (int i = 1; i <= V; i++) {
            for (int k = 1; k <= V; k++) {
                for (int j = 1; j <= V; j++) {
                    if(graph[i][j] == 0)
                        graph[i][j] = graph[i][k] + graph[k][j];
                    else
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    static int stringToInt(String s) {
        return Integer.parseInt(s);
    }
}