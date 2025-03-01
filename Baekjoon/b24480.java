import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b24480 {

    static int N,M,R,count = 1; // 정점 수, 간선 수, 시작 정점
    static ArrayList<Integer>[] list;
    static int[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = sToInt(st.nextToken());
        M = sToInt(st.nextToken());
        R = sToInt(st.nextToken());
        isVisited = new int[N+1];
        list = new ArrayList[N+1];

        for (int i = 0 ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = sToInt(st.nextToken());
            int b = sToInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ;i ++)
            sb.append(isVisited[i]+"\n");
        System.out.println(sb);
    }

    static int sToInt(String s){
        return Integer.parseInt(s);
    }

    static void DFS(int start){
        isVisited[start] = count++;
        list[start].sort(Collections.reverseOrder());
        for (int next : list[start]){
            if(isVisited[next]==0)
                DFS(next);
        }
    }
}