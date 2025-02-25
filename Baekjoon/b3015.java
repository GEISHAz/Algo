import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b3015 {

    static class Node {
        int height;
        int count;

        public Node(int h, int cnt) {
            this.height = h;
            this.count = cnt;
        }
    }

    static int N;
    static Stack<Node> st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new Stack<>();
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!st.isEmpty() && st.peek().height <= height) {
                Node top = st.pop();
                answer += top.count;

                if (top.height == height) {
                    count += top.count;
                }
            }

            if (!st.isEmpty()) {
                answer++;
            }

            st.push(new Node(height, count));
        }

        System.out.println(answer);
    }
}
