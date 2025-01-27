import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b24479 {

    static int N, M, R;
    static int[] ans;
    static ArrayList<Integer>[] list;
    static int count; // 방문 순서 카운트를 static 변수로 분리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        count = 1; // 초기값 설정
        DFS(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int r) {
        ans[r] = count++;
        for (int next : list[r]) {
            if (ans[next] == 0) { // 방문하지 않은 정점인 경우
                DFS(next);
            }
        }
    }
}

