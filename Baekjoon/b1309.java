import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[100_001];
        int N = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 7;

        if(N >= 3){
            for (int i = 3 ; i < N+1 ; i++)
                arr[i] = (arr[i-1]*2 + arr[i-2])%9901;

        }
        System.out.println(arr[N]);
    }
}
