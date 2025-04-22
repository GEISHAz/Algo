import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

    public class b13913 {

        static int[] dp,prav;
        static int start, end;

        static class Node{
            int value;
            int cnt;
            public Node(int value, int cnt) {
                this.value = value;
                this.cnt = cnt;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            dp = new int[100101];
            prav = new int[100101];
            Arrays.fill(dp, Integer.MAX_VALUE);
            StringTokenizer st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            prav[start] = -1;

            Node answer = bfs(start,end);

            Stack<Integer> stack = new Stack<>();
            int idx = end;
            String ans = "";
            while(idx != -1){
                stack.push(idx);
                idx = prav[idx];
            }
            while(!stack.isEmpty()){
                ans = ans+" "+stack.pop();
            }
            System.out.println(answer.cnt);
            System.out.println(ans.substring(1));
        }
        static Node bfs(int start, int end) {
            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(start, 0));
            while (!q.isEmpty()) {
                Node now = q.poll();
                if (now.value == end)
                    return now;
                if ((now.value - 1) >= 0 && dp[now.value - 1] > now.cnt + 1) {
                    dp[now.value - 1] = now.cnt + 1;
                    prav[now.value -1] = now.value;
                }
                if ((now.value + 1) <= 100000 && dp[now.value + 1] > now.cnt + 1) {
                    dp[now.value + 1] = now.cnt + 1;
                    prav[now.value +1] = now.value;
                }
                if ((now.value * 2) <= 100000 && dp[now.value * 2] > now.cnt + 1) {
                    dp[now.value * 2] = now.cnt + 1;
                    prav[now.value *2] = now.value;
                }
            }
            return null;
        }
    }