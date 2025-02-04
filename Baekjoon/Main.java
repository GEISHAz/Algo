import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] numbers;
    static int[] checkNum;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        output();
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim()); // 마지막 공백 제거
    }

    private static void logic() {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && checkNum[numbers[i]] >= checkNum[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else if (checkNum[numbers[i]] < checkNum[stack.peek()]) {
                answer[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        checkNum = new int[1000001];
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            checkNum[numbers[i]]++;
        }
    }
}