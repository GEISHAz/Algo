import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1707 {

    static class Node {
        int num;
        boolean color;

        public Node(int num, boolean color) {
            this.num = num;
            this.color = color;
        }
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = stringToInteger(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = stringToInteger(st.nextToken());  // 정점
            int E = stringToInteger(st.nextToken());  // 간선
            sb.append(logic(N, E, br));
        }
        System.out.println(sb);
    }

    static String logic(int N, int E, BufferedReader br) throws IOException {
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer stLogic = new StringTokenizer(br.readLine());
            int a = stringToInteger(stLogic.nextToken());
            int b = stringToInteger(stLogic.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int[] colors = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0) {
                if (!BFS(i, list, colors)) return "NO\n";
            }
        }

        return "YES\n";
    }

    static boolean BFS(int start, ArrayList<Integer>[] list, int[] colors) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, true));
        colors[start] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curColor = colors[cur.num];

            for (int next : list[cur.num]) {
                if (colors[next] == 0) {
                    colors[next] = -curColor;
                    q.add(new Node(next, !cur.color));
                } else if (colors[next] == curColor) {
                    return false;
                }
            }
        }
        return true;
    }

    static int stringToInteger(String s) {
        return Integer.parseInt(s);
    }
}