import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b6497 {

    static class Road implements Comparable<Road> {

        int s;
        int e;
        int degree;

        Road(int s, int e, int degree) {
            this.s = s;
            this.e = e;
            this.degree = degree;
        }

        @Override
        public int compareTo(Road o) {
            return this.degree - o.degree;
        }

    }

    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //집
            M = Integer.parseInt(st.nextToken()); //길
            if(N == M && N == 0) break;
            PriorityQueue<Road> pq = new PriorityQueue<>();
            p = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                p[i] = i;
            }
            int answer = 0, total = 0;

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int degree = Integer.parseInt(st.nextToken());
                total += degree;
                pq.add(new Road(a, b, degree));
            }

            int count = 0;
            while (!pq.isEmpty() && count < N - 1) {
                Road road = pq.poll();
                if (find(p[road.s]) == find(p[road.e])) continue; // 이미 연결된 집이라면
                union(road.s, road.e);
                answer += road.degree;
                count++;
            }

            sb.append(total-answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) { // 집연결
        int fa = find(a);
        int fb = find(b);
        int parent = Math.min(fa, fb);
        p[fa] = parent;
        p[fb] = parent;
    }

    private static int find(int a) {
        if (a == p[a]) return a;
        return p[a] = find(p[a]);
    }
}