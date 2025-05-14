import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1774 {

    static int N, M;
    static int[] p;
    static int[][] gods;

    static class Line implements Comparable<Line> {
        int a,b;
        double value;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
            this.value = getDistance(a,b);
        }

        @Override
        public int compareTo(Line o) {
            return Double.compare(this.value,o.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gods = new int[N+1][2];
        PriorityQueue<Line> pq = new PriorityQueue<Line>();
        p = new int[N+1];
        p[0] = 0;
        int count = 0;
        double answer = 0;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            gods[i][0] = Integer.parseInt(st.nextToken());
            gods[i][1] = Integer.parseInt(st.nextToken());
            p[i] = i;
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a,b)) count++;
        }

        for(int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.add(new Line(i,j));
            }
        }
        while (!pq.isEmpty()) {
            if (count == N - 1) break;

            Line l = pq.poll();
            if (union(l.a, l.b)) {
                answer += l.value;
                count++;
            }
        }

        System.out.println(String.format("%.2f", answer));
    }
    private static int find (int a){
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false; // 이미 같은 집합 = 사이클
        p[pb] = pa; // union
        return true;
    }

    private static double getDistance(int a, int b) {
        return Math.sqrt(Math.pow(gods[a][0]-gods[b][0],2) + Math.pow(gods[a][1]-gods[b][1],2));
    }
}