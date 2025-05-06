import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1976 {

    static int n,m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = toInteger(br.readLine());
        m = toInteger(br.readLine());
        p = new int[n+1];

        for(int i = 1; i <= n; i++)
            p[i] = i;

        for(int i = 1 ; i <= n ; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 1 ; j <= n ;j++){
                int input = toInteger(str[j-1]);
                if(input == 1){
                    union(i,j);
                }
            }
        }
        String[] s = br.readLine().split(" ");
        boolean check = false;
        for(int i = 1 ; i < m ; i++){
            if(find(toInteger(s[i-1]))!=find(toInteger(s[i]))){
                check = true;
                break;
            }
        }
        sb.append(check ? "NO" : "YES");
        System.out.println(sb);
    }

    private static int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return;
        if(pa > pb){
            int temp = pa;
            pa = pb;
            pb = temp;
        }
        p[pa] = pb;
    }

    private static int toInteger(String s) {
        return Integer.parseInt(s);
    }
}