import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[][] isAns = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            isAns[i][i] = true;
            if(i != N-1 && arr[i] == arr[i+1]) isAns[i][i+1] = true;
        }

        for (int len = 2; len < N; len++) {
            for (int s = 0; s + len < N; s++) {
                int e = s + len;
                if (arr[s] == arr[e] && isAns[s + 1][e - 1]) {
                    isAns[s][e] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            sb.append(isAns[a][b]?1:0).append("\n");
        }
        System.out.println(sb);

    }
}



//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        String str = br.readLine().replaceAll(" ", "");
//
//        int M = Integer.parseInt(br.readLine());
//        for(int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//
//            int a = Integer.parseInt(st.nextToken())-1;
//            int b = Integer.parseInt(st.nextToken())-1;
//            String s = str.substring(a, b+1);
//            String rs = new StringBuilder(s).reverse().toString();
//
//            sb.append((s.equals(rs))?1:0).append("\n");
//        }
//        System.out.println(sb);
//    }
//}