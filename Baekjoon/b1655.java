import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 (메인)
        PriorityQueue<Integer> subpq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        int N = Integer.parseInt(br.readLine());
        for( int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
            if((!pq.isEmpty() && !subpq.isEmpty()) && pq.peek() < subpq.peek()){
                pq.add(subpq.remove());
                subpq.add(pq.poll());
            }
            if(pq.size() > subpq.size()+2)
                subpq.add(pq.poll());
            else if(pq.size() == subpq.size()){
                pq.add(subpq.poll());
            }
            sb.append(pq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}