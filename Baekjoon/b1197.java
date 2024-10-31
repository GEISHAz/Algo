import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1197 {
    private static int[] p;
    private static int  find(int a){
        if(p[a]!=a)
            p[a] = find(p[a]);
        return p[a];
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!= b)
            p[b] = a;
    }
    static class Road{
        int from;
        int to;
        int degree;
        public Road(int from, int to, int degree){
            this.from = from;
            this.to = to;
            this.degree = degree;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = input[0];
        int E = input[1];
        Road[] road = new Road[E];
        int answer = 0;
        p = new int[V+1];
        for(int i = 0 ; i < V ; i++)
            p[i] = i;

        for(int i = 0 ; i < E ; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            road[i] = new Road(arr[0],arr[1],arr[2]);
        }

        Arrays.sort(road,(o1, o2) -> o1.degree-o2.degree);

        for(int i = 0 ; i < E ; i++){
            if(find(road[i].from) != find(road[i].to)) {
                union(road[i].from, road[i].to);
                answer += road[i].degree;
            }
        }
        System.out.println(answer);
    }
}