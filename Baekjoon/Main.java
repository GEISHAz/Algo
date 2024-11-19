import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] degrees;
    private static ArrayList<Integer>[] lists;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        degrees = new int[N+1];
        lists = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degrees[b] += 1;
            lists[a].add(b);
        }

        pq = new PriorityQueue<>();

        // 모든 노드를 탐색하여 진입 차수가 0인 노드를 초기화 시 한 번에 큐에 추가
        for(int i = 1 ; i <= N ; i++){
            if(degrees[i] == 0){
                pq.add(i);
            }
        }

        // 위상 정렬 수행
        while (!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            for (int num : lists[now]){
                degrees[num] -= 1;
                if (degrees[num] == 0) {
                    pq.add(num);
                }
            }
        }

        System.out.println(sb);
    }
}