import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b4195 {

    static int t, n;
    static HashMap<String, Integer> name;
    static int[] p;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            p = new int[100_001];     // 충분한 크기 확보
            size = new int[100_001];  // 각 집합의 크기
            name = new HashMap<>();
            int count = 1;

            for (int j = 0; j < 100_001; j++) {
                p[j] = j;
                size[j] = 1;
            }

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!name.containsKey(a)) name.put(a, count++);
                if (!name.containsKey(b)) name.put(b, count++);

                int rootSize = union(name.get(a), name.get(b));
                sb.append(rootSize).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]); // 경로 압축
        }
        return p[x];
    }

    private static int union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return size[pa];

        if (pa < pb) {
            p[pb] = pa;
            size[pa] += size[pb];
            return size[pa];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
            return size[pb];
        }
    }
}