import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2618 {

    public static int[][] list = new int[1002][2];
    public static int event_num, line_num;
    public static int[][] dp = new int[1002][1002];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line_num = Integer.parseInt(br.readLine());
        event_num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= event_num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정답 출력
        System.out.println(police(0, 0));

        // 경로 추적
        int one = 0, two = 0;
        for (int i = 1; i <= event_num; i++) {
            int dist1 = getDistance(one, i, 1);
            int dist2 = getDistance(two, i, 2);

            if (dp[i][two] + dist1 == dp[one][two]) {
                System.out.println(1);
                one = i;
            } else {
                System.out.println(2);
                two = i;
            }
        }
    }

    // DP로 최소 거리 계산
    public static int police(int one, int two) {
        int next = Math.max(one, two) + 1;

        if (next > event_num) return 0;
        if (dp[one][two] != 0) return dp[one][two];

        int move1 = police(next, two) + getDistance(one, next, 1);
        int move2 = police(one, next) + getDistance(two, next, 2);

        dp[one][two] = Math.min(move1, move2);
        return dp[one][two];
    }

    // 거리 계산
    public static int getDistance(int from, int to, int police) {
        int x1, y1;

        if (from == 0) {
            x1 = (police == 1) ? 1 : line_num;
            y1 = (police == 1) ? 1 : line_num;
        } else {
            x1 = list[from][0];
            y1 = list[from][1];
        }

        int x2 = list[to][0];
        int y2 = list[to][1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}