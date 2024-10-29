import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class b1005 {
    private static Queue<Integer> q;
    private static int[] inDegree, times, buildCost;
    private static boolean[] isVisited;
    private static int N, K, T, W, answer;
    private static ArrayList<Integer>[] list;
    private static BufferedReader br;

    private static void prepare() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        isVisited = new boolean[N];
        inDegree = new int[N];
        buildCost = new int[N];
        q = new ArrayDeque<>();
        answer = 0;
        times = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            inDegree[i] = 0;
            buildCost[i] = times[i]; // 초기화 시 각 건물의 건설 시간으로 시작
        }

        for (int i = 0; i < K; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list[arr[0] - 1].add(arr[1] - 1);
            inDegree[arr[1] - 1]++;
        }

        W = Integer.parseInt(br.readLine()) - 1;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            prepare();

            // 초기 진입 차수가 0인 건물들을 큐에 넣기
            for (int i = 0; i < N; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                isVisited[now] = true;

                // 종료 조건: 목표 건물을 짓기 위한 누적 시간 계산 후 출력
                if (now == W) {
                    answer = buildCost[now];
                    sb.append(answer).append("\n");
                    break;
                }

                // 현재 건물을 통해 연결된 다음 건물들의 비용 업데이트
                for (int next : list[now]) {
                    buildCost[next] = Math.max(buildCost[next], buildCost[now] + times[next]);
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        q.add(next); // 진입 차수가 0이 된 건물을 큐에 추가
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
