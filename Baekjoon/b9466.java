import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9466 {

    static int n,count = 0;
    static int[] arr;
    static boolean[] isVisited, isChecked;

    static int stoi(String s){ return Integer.parseInt(s); }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = stoi(br.readLine());

        for (int t = 0 ; t < T ; t++){
            n = stoi(br.readLine());
            arr = new int[n+1];
            isVisited = new boolean[n+1];
            isChecked = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i++)
                arr[i] = stoi(st.nextToken());

            for (int i = 1; i <= n ; i++){
                dfs(i);
            }
            System.out.println(n - count);
        }
    }
    public static void dfs(int now){
        if(isVisited[now]) return;

        isVisited[now] = true;
        int next = arr[now];

        if (!isVisited[next])
            dfs(next);
        else {
            if (!isChecked[next]){
                count ++;
                for (int i = next ; i != now ; i = arr[i])
                    count++;
            }
        }
        isChecked[now] = true;
    }
}
