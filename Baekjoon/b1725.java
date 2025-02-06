import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1725 {

    static int N;
    static long answer;
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        answer = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int start = i;

            while (!stack.isEmpty() && stack.peek()[0] > num) {
                int[] top = stack.pop();
                answer = Math.max(answer, (long) top[0] * (i - top[1]));
                start = top[1];
            }

            stack.push(new int[]{num, start});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            answer = Math.max(answer, (long) top[0] * (N - top[1]));
        }

        System.out.println(answer);
    }
}