import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b4386 {

    static int N;
    static double[][] stars;
    static double[] dis;
    static double DOUBLE_MAX = Double.MAX_VALUE;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        isVisited = new boolean[N];
        dis = new double[N];

        Arrays.fill(isVisited, Boolean.FALSE);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());;
            stars[i][1] = Double.parseDouble(st.nextToken());
            dis[i] = DOUBLE_MAX;
        }
        dis[0] = 0;
        double answer = 0;

        for (int i = 0; i < N; i++) {
            int u = -1;
            double min = Double.MAX_VALUE;
            for(int j = 0 ; j < N; j++){
                if(!isVisited[j] && dis[j] < min){
                    min = dis[j];
                    u = j;
                }
            }
            isVisited[u] = true;
            answer += dis[u];

            for( int v = 0 ; v < N; v++){
                if(!isVisited[v]){
                    dis[v] = Math.min(dis[v],getDistance(u, v));
                }
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    private static double getDistance(int i, int j) {
        return Math.sqrt(Math.pow(Math.abs(stars[i][0] - stars[j][0]), 2) + Math.pow(Math.abs(stars[i][1] - stars[j][1]), 2));
    }
}