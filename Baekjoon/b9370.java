import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b9370 {

    static int T,N,M,D; //교차로, 도로, 목적지 후보 갯수
    static int S,G,H;   //출발지, G와 H 사이의 도로를 지나감
    static HashMap<Integer,ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {
        int spot;
        int distance;

        public Node(int spot, int distance){
            this.spot=spot;
            this.distance=distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = stringToInteger(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stringToInteger(st.nextToken());
            M = stringToInteger(st.nextToken());
            D = stringToInteger(st.nextToken());

            st = new StringTokenizer(br.readLine());
            S = stringToInteger(st.nextToken());
            G = stringToInteger(st.nextToken());
            H = stringToInteger(st.nextToken());

            graph = new HashMap<>();
            for(int i = 1; i <= N ; i++) graph.put(i,new ArrayList<>());

            int ghDistance = 0;
            for(int m = 0 ; m < M ; m++) {
                st = new StringTokenizer(br.readLine());
                int a = stringToInteger(st.nextToken());
                int b = stringToInteger(st.nextToken());
                int d = stringToInteger(st.nextToken());
                graph.get(a).add(new Node(b,d));
                graph.get(b).add(new Node(a,d));

                if((a == G && b == H) || (a == H && b == G)) ghDistance = d;
            }

            int[] distFromS = dijkstra(S);
            int[] distFromG = dijkstra(G);
            int[] distFromH = dijkstra(H);

            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < D; i++) {
                int target = stringToInteger(br.readLine());
                int directDist = distFromS[target];

                // G-H 간선을 경유하는 두 가지 경로 비교
                int viaGH = distFromS[G] + ghDistance + distFromH[target];
                int viaHG = distFromS[H] + ghDistance + distFromG[target];

                if (directDist == viaGH || directDist == viaHG) {
                    results.add(target);
                }
            }

            Collections.sort(results);
            StringBuilder sb = new StringBuilder();
            for (int res : results) sb.append(res).append(" ");
            System.out.println(sb);
        }
    }

    private static int[] dijkstra(int s) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curSpot = cur.spot;
            int curDist = cur.distance;

            if (dist[curSpot] < curDist) continue;

            for(Node next : graph.get(curSpot)) {
                int newDist = curDist + next.distance;
                if (newDist < dist[next.spot]) {
                    dist[next.spot] = newDist;
                    pq.add(new Node(next.spot, newDist));
                }
            }
        }
        return dist;
    }

    private static int stringToInteger(String s) throws IOException {
        return Integer.parseInt(s);
    }
}