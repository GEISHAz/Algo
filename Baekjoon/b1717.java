import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1717 {

    static int n,m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = toInteger(st.nextToken());
        m = toInteger(st.nextToken());

        p = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            p[i]=i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int sign = toInteger(st.nextToken());
            int a = toInteger(st.nextToken());
            int b = toInteger(st.nextToken());

            if(sign==0){
                union(a,b);
            }
            else{
                if(find(a) == find(b))
                    sb.append("YES");
                else
                    sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int find(int a){
        if(p[a]==a) return a;
        return p[a]=find(p[a]);
    }

    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa > pb){
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }
        p[pb] = p[pa];
    }

    private static int toInteger(String s) {
        return Integer.parseInt(s);
    }
}