import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11657 {

    static class Node {
        int start, end, time;

        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static int N, M;
    static ArrayList<Node> edges;
    static long[] dist; // long 타입 사용 (오버플로우 방지)
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 시작점 거리 0

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a, b, c));
        }

        // 벨만-포드 수행
        if (bellmanFord()) {
            System.out.println("-1"); // 음수 사이클 존재 시 -1 출력
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) { // 1번 도시 제외 출력
                if (dist[i] == INF) {
                    sb.append("-1\n"); // 도달할 수 없는 경우 -1 출력
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    private static boolean bellmanFord() {
        boolean hasCycle = false;

        // N-1번 반복 (최단 거리 갱신)
        for (int i = 1; i < N; i++) {
            for (Node edge : edges) {
                if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                }
            }
        }

        // 음수 사이클 체크 (N번째 갱신 시 값이 변하면 사이클 존재)
        for (Node edge : edges) {
            if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
                hasCycle = true;
                break;
            }
        }

        return hasCycle;
    }
}