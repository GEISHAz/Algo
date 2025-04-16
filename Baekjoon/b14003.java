import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14003 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = toInt(br.readLine());

        int[] arr = new int[N];
        int[] list = new int[N + 1]; // LIS 길이 추적
        int[] dp = new int[N];       // arr[i]가 LIS 몇 번째에 있는지
        int[] prev = new int[N];     // LIS 경로 추적용
        int[] lastIndex = new int[N]; // 길이별 마지막 인덱스

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        int top = 0;
        list[0] = arr[0];
        dp[0] = 1;
        prev[0] = -1;
        lastIndex[0] = 0;

        for (int i = 1; i < N; i++) {
            int val = arr[i];

            if (val > list[top]) {
                list[++top] = val;
                dp[i] = top + 1;
                prev[i] = lastIndex[top - 1];
                lastIndex[top] = i;
            } else {
                int left = 0, right = top;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list[mid] >= val)
                        right = mid;
                    else
                        left = mid + 1;
                }
                list[left] = val;
                dp[i] = left + 1;
                prev[i] = (left == 0) ? -1 : lastIndex[left - 1];
                lastIndex[left] = i;
            }
        }

        System.out.println(top + 1);

        int[] result = new int[top + 1];
        int resultIdx = top;
        int idx = lastIndex[top];
        while (idx != -1) {
            result[resultIdx--] = arr[idx];
            idx = prev[idx];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }
}