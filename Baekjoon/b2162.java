import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2162 {
    static int N;
    static int[] parent, size;


    //점
    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //선
    static class Line {
        Dot start, end;

        public Line(Dot start, Dot end) {
            if (start.x > end.x || (start.x == end.x && start.y > end.y)) {
                Dot temp = start;
                start = end;
                end = temp;
            }
            this.start = start;
            this.end = end;
        }
    }

    //find
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    //union
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }

    static int ccw(Dot a, Dot b, Dot c) {
        long value = (long) (b.x - a.x) * (c.y - a.y) - (long) (b.y - a.y) * (c.x - a.x);
        return Long.compare(value, 0);
    }

    static boolean isCross(Line l1, Line l2) {
        Dot a = l1.start, b = l1.end;
        Dot c = l2.start, d = l2.end;
        int ccw1 = ccw(a, b, c) * ccw(a, b, d);
        int ccw2 = ccw(c, d, a) * ccw(c, d, b);

        if (ccw1 == 0 && ccw2 == 0) {
            return Math.min(a.x, b.x) <= Math.max(c.x, d.x) && Math.min(c.x, d.x) <= Math.max(a.x, b.x) &&
                    Math.min(a.y, b.y) <= Math.max(c.y, d.y) && Math.min(c.y, d.y) <= Math.max(a.y, b.y);
        }
        return ccw1 <= 0 && ccw2 <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            lines[i] = new Line(new Dot(x1, y1), new Dot(x2, y2));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isCross(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        int groupCount = 0;
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            if (find(i) == i) groupCount++;
            maxSize = Math.max(maxSize, size[find(i)]);
        }

        System.out.println(groupCount);
        System.out.println(maxSize);
    }
}
