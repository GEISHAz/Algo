//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//
//public class Main {
//
//    private static int N,S,maximum;
//    private static int[] arr;
//    private static long[] dp;
//
//    private static int find(int start){
//        for(int i = start ; i <= N; i++){ //길이
//            for(int j = 0 ; j <= N-i ; j++){ // 길이탐색
//                if(dp[i+j]-dp[j]>=S) return i;
//            }
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        S = Integer.parseInt(st.nextToken());
//        String s = br.readLine();
//        arr = Arrays.stream(s.split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        maximum = Arrays.stream(arr).max().orElse(0);
//        dp = new long[N+1];
//        dp[0] = 0;
//        dp[1] = arr[0];
//
//        if(maximum == 0)
//            System.out.println(0);
//
//        for(int i = 1 ; i <= N; i++)
//            dp[i]=dp[i-1]+arr[i-1];
//
//        System.out.println(find(S/maximum));
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1806 {

    private static int N, S;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}


