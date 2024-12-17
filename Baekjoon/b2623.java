import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2623 {

    static int N, M; // 가수 수 N , 보조 PD 수 M
    static ArrayList<Integer>[] singer;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        singer = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0 ; i <= N ; i++)
            singer[i] = new ArrayList<>();

        for (int i = 0 ; i < M ; i++){
            String[] input = br.readLine().split(" ");
            int pdCount = Integer.parseInt(input[0]);

            for(int j = 1 ; j <= pdCount ; j++ ){
                int now  = Integer.parseInt(input[j]);
                for (int k = j+1 ; k <= pdCount; k++){
                    int target  = Integer.parseInt(input[k]);
                    if(!singer[target].contains(now)) singer[target].add(now);  // ?
                }
            }
        }
        int[] singerCount = new int[N+1];
        Arrays.fill(singerCount,0);
        for(int i = 1 ; i <= N; i++){
            int count = singer[i].size();
            singerCount[i] = count;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1 ; i <= N ; i++)
            if(singerCount[i] == 0) {
                isVisited[i] = true;
                q.add(i);
            }

        if (q.isEmpty()) {
            System.out.println(0);
            return ;
        }

        int ansCount = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now = q.poll();
            ansCount ++;
            sb.append(now);
            sb.append('\n');
            for (int i = 1 ; i <= N ; i++) {
                if (i == now) continue;
                if (singer[i].contains(now))
                    singerCount[i]--;
                if (singerCount[i] == 0 && !isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
        if (ansCount == N)
            System.out.println(sb);
        else
            System.out.println(0);
    }
}
