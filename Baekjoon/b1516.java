import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1516 {

    static int N;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[N + 1][N + 1];
        int[] times = new int[N + 1];
        int[] degree = new int[N + 1];

        // --- 수정된 부분 (입력 및 그래프 생성) ---
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i + 1] = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken()); // b는 i+1의 선행 작업
                if (b == -1) break;
                graph[b][i + 1] = true; // 올바른 방향: b -> i+1
                degree[i + 1]++;      // i+1의 진입 차수 증가
            }
        }
        // --- 수정 끝 ---

        int[] answer = topologySort(graph, times, degree);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i + 1]).append("\n");
        }
        System.out.println(sb);
    }

    // --- 수정된 부분 (위상 정렬 로직) ---
    private static int[] topologySort(boolean[][] graph, int[] times, int[] degree) {
        int[] result = new int[N + 1];

        // 1. 진입 차수가 0인 노드를 큐에 넣고, 초기 완료 시간을 자신의 소요 시간으로 설정
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
                result[i] = times[i];
            }
        }

        // 2. 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[now][i]) { // now -> i 간선이 존재하면
                    // i의 완료 시간 = max(기존 i의 완료 시간, 선행작업 now의 완료시간 + i의 소요시간)
                    result[i] = Math.max(result[i], result[now] + times[i]);
                    degree[i]--;

                    if (degree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        return result;
    }
    // --- 수정 끝 ---
}