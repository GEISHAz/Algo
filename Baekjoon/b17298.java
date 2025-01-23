import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17298 {

    static int N;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        logic();

        sb = new StringBuilder();
        for (int i = 0 ; i < N ; i++){
            sb.append(numbers[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void logic() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                numbers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            numbers[stack.pop()] = -1;
    }
}
