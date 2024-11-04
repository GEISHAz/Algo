import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1202 {
    private static Jewelry[] j;
    private static int[] input;
    private static class Jewelry{
        int cost;
        int price;
        public Jewelry(int cost, int price){
            this.cost = cost;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        j = new Jewelry[N];
        input = new int[K];
        long answer = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            j[i] = new Jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(j,(o1,o2)->{
            if(o2.cost == o1.cost)
                return o2.price - o1.price;
            return o1.cost-o2.cost;
        });
        for(int i = 0 ; i < K ; i++ ){
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0, l = 0; i < K ; i++){
            while(l < N && j[l].cost<=input[i]){
                pq.offer(j[l++].price);
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}