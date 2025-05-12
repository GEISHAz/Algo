import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b20040 {

    static int N, M;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        boolean check = true;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                sb.append(i+1);
                check = false;
                break;
            }else{
                union(a,b);
            }
        }
        if(check)
            System.out.println(0);
        else
            System.out.println(sb);
    }
    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pb < pa){
            int temp = pa;
            pa = pb;
            pb = temp;
        }
        p[pb] = pa;
    }
    private static int find(int a) {
        if(a == p[a]) return p[a];
        return p[a]=find(p[a]);
    }
}