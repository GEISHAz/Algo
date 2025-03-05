import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b24445 {

    static int N, M, R;
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoInt(st.nextToken());
        M = stoInt(st.nextToken());
        R = stoInt(st.nextToken());
        isVisited = new boolean[N+1];
        result = new int[N+1];
        list = new ArrayList[N+1];

        inputAndSort(br);

        BFS(R);

        printResult();
    }

    private static void inputAndSort(BufferedReader br) throws IOException {
        StringTokenizer st ;
        for (int i = 0; i <= N ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = stoInt(st.nextToken());
            int b = stoInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0 ; i <= N ; i++){
            list[i].sort(Collections.reverseOrder());
        }
    }

    static int stoInt(String s){
        return Integer.parseInt(s);
    }

    static void BFS(int r){
        int count = 1;
        q.add(r);
        while(!q.isEmpty()){
            int now = q.poll();
            result[now] = count++;
            isVisited[r]=true;
            for(int i = 0 ; i < list[now].size() ; i++){
                int num = list[now].get(i);
                if (!isVisited[num]) {
                    q.add(num);
                    isVisited[num] = true;
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= N ; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}