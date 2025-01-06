import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b6549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getMaxRectangleArea(heights));
        }
    }

    private static long getMaxRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, (long) height * width);
        }
        return maxArea;
    }
}
