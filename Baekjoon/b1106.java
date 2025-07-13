import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // dp[i] := i명의 고객을 유치하기 위한 최소 비용
        // C명 이상일 때 더 저렴한 경우가 있을 수 있으므로 C + 100까지 배열을 생성
        int[] dp = new int[C + 101];
        Arrays.fill(dp, 100_000_000); // 충분히 큰 값으로 초기화
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customers = Integer.parseInt(st.nextToken());
            // 현재 홍보 활동으로 갱신할 수 있는 모든 경우를 업데이트
            for (int j = customers; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - customers] + cost);
            }
        }

        // C명부터 C+100명까지의 비용 중 최솟값을 찾음
        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}