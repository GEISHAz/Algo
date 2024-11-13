import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1647 {

    private static int[] p;
    private static PriorityQueue<int[]> pq;

    private static int find(int a){
        if(p[a] == a) return a;
        else return p[a] = find(p[a]);
    }

    private static void union(int a, int b){
        p[find(a)] = find(b);
    }

    private static int calculate(){
        int max = Integer.MIN_VALUE, sum = 0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(find(arr[0]) != find(arr[1])){
                union(arr[0], arr[1]);
                max = Math.max(max, arr[2]);
                sum += arr[2];
            }
        }
        return sum - max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for(int i = 0 ; i < N ; i++){
            p[i] = i;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = {Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())};
            pq.add(arr);
        }
        System.out.println(calculate());
    }
}