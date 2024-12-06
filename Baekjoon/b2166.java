import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2166 {

    private static int N;
    private static long[][] arr;

    static double calculate(){
        double sum1 = 0,sum2 = 0;
        for (int i = 0 ; i < N ; i ++){
            sum1 += arr[i][0] * arr[(i+1)%N][1];
            sum2 += arr[i][1] * arr[(i+1)%N][0];
        }
        return (sum1-sum2)/2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N][2];
        StringTokenizer st;


        for (int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.printf("%.1f%n",Math.abs(calculate()));

    }
}
