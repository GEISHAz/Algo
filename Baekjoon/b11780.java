import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

    public class b11780 {

        static int N,M,INF = 100_001;
        static int[][] costs;
        static List<Integer>[][] lists;
        static StringBuilder sb;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            costs = new int[N+1][N+1];
            lists = new ArrayList[N+1][N+1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    lists[i][j] = new ArrayList<>();
                    if(i!=j)
                        costs[i][j] = INF;
                }
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                costs[a][b] = Math.min(cost, costs[a][b]);
            }

            for(int k = 1; k <= N; k++){
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if(costs[i][j] > costs[i][k]+costs[k][j]){
                            costs[i][j] = costs[i][k]+costs[k][j];
                            routeTracking(i,j,k);
                        }
                    }
                }
            }
            printMap();
            printRoute();
            System.out.println(sb);
        }
        public static void routeTracking(int i, int j, int k){
            lists[i][j].clear();
            for(int route : lists[i][k])
                lists[i][j].add(route);
            lists[i][j].add(k);
            for(int route : lists[k][j])
                lists[i][j].add(route);
        }
        static void printMap() {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(costs[i][j] == INF) {
                        sb.append(0+" ");
                        continue;
                    }
                    sb.append(costs[i][j]+" ");
                }
                sb.append("\n");
            }
        }

        static void printRoute() {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    int size = lists[i][j].size();
                    if(i==j || costs[i][j] == INF) {
                        sb.append(0+"\n");
                        continue;

                    }
                    sb.append((size+2)+" "+ i+" ");
                    for(int num : lists[i][j]) {
                        sb.append(num+" ");
                    }
                    sb.append(j+"\n");
                }
            }
        }

    }