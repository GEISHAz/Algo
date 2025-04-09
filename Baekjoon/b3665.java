import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b3665 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = toInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<Integer>[] graph = logic(br);

            int N = graph.length - 1;
            int[] indegree = new int[N + 1];
            for (int u = 1; u <= N; u++) {
                for (int v : graph[u]) {
                    indegree[v]++;
                }
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 1; j <= N; j++) {
                if (indegree[j] == 0) {
                    pq.offer(j);
                }
            }

            StringBuilder sb = new StringBuilder();
            List<Integer> result = new ArrayList<>();
            boolean uncertain = false;

            while (!pq.isEmpty()) {
                if (pq.size() > 1) {
                    uncertain = true;
                }

                int curr = pq.poll();
                result.add(curr);

                for (int next : graph[curr]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        pq.offer(next);
                    }
                }
            }

            if (result.size() != N) {
                System.out.println("IMPOSSIBLE");
            } else if (uncertain) {
                System.out.println("?");
            } else {
                for (int x : result) {
                    sb.append(x).append(" ");
                }
                System.out.println(sb);
            }
        }
    }

    static ArrayList<Integer>[] logic(BufferedReader br) throws IOException {
        int N = toInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = toInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                graph[arr[i]].add(arr[j]);
            }
        }

        int M = toInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());

            if (graph[a].contains(b)) {
                graph[a].remove((Integer) b);
                graph[b].add(a);
            } else {
                graph[b].remove((Integer) a);
                graph[a].add(b);
            }
        }

        return graph;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}