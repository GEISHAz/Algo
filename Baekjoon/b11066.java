import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11066 {

    static int T, N;
    static int[][] dp;
    static int[] prefixSum,fileSize;

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        fileSize = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[N][N];
        prefixSum = new int[N];

        prefixSum[0] = fileSize[0];
        for (int i = 1; i < N; i++)
            prefixSum[i] = prefixSum[i-1] + fileSize[i];
    }

    private static void logic() {
        for (int d = 1 ; d < N; d++){
            for (int i = 0; i < N - d; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i ; k < j ; k++){
                    int cost = dp[i][k]+dp[k+1][j]+(prefixSum[j] - (i > 0 ? prefixSum[i-1]:0));
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T ; t++){
            init(br);
            logic();
        }
    }
}























//public class Main {
//
//    static int T, N, answer;
//
//    static PriorityQueue<Integer> pq;
//
//    private static void logic(){
//        while(pq.size()>=2){
//            int sum = pq.poll()+pq.poll();
//            answer += sum;
//            pq.add(sum);
//        }
//    }
//
//    private static void init(BufferedReader br) throws IOException {
//
//        pq = new PriorityQueue<>();
//        answer = 0;
//        N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        while(st.hasMoreTokens())
//            pq.add(Integer.parseInt(st.nextToken()));
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        T = Integer.parseInt(br.readLine());
//        for (int t = 0; t < T ; t++){
//            init(br);
//            logic();
//            System.out.println(answer);
//        }
//    }
//
//
//}
