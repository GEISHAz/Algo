import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class b4803 {

    static int N,M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            p = new int[N+1];
            for(int i = 0 ; i < N+1; i++)
                p[i] = i;

            for(int i = 0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }

            sb.append("Case ").append(cnt++).append(": ");
            HashSet<Integer> set = new HashSet<>();

            for(int i = 1; i<N+1; i++){
                int tree = find(i);
                if(tree>0)
                    set.add(tree);
            }
            if(set.size() == 1)
                sb.append("There is one tree.").append("\n");
            else if (set.isEmpty())
                sb.append("No trees.").append("\n");
            else
                sb.append("A forest of ").append(set.size()).append(" trees.").append("\n");
        }
        System.out.println(sb);
    }
    static int find(int a){
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa > pb){
            int temp = pa;
            pa = pb;
            pb = temp;
        }
        if(pa == pb){
            p[pa] = 0;
        }
        else{
            p[pb] = p[pa];
        }
    }
}