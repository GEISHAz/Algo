import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2696 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = toInt(br.readLine());
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>(Collections.reverseOrder());

        for(int t = 0 ; t < T ; t++){

            left.clear();
            right.clear();

            int N = toInt(br.readLine());

            StringBuilder input = new StringBuilder();
            for(int i = 0; i < N ; i += 10){
                input.append(br.readLine()).append(" ");
            }
            StringTokenizer st = new StringTokenizer(input.toString());
            StringBuilder sb = new StringBuilder();

            int answer = 0;

            for(int i = 0; i < N; i++){

                int num = toInt(st.nextToken());

                if(left.isEmpty() || left.peek() < num){
                    left.offer(num);
                }else{
                    right.offer(num);
                }

                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                } else if (right.size() > left.size()) {
                    left.offer(right.poll());
                }

                if(i % 2 == 0){
                    answer++;
                    sb.append(left.peek()).append(" ");
                }

            }
            System.out.println(answer);
            System.out.println(sb);
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}