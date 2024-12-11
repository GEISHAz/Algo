import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2473 {

    static int N;
    static long minimum = Long.MAX_VALUE;
    static long[] arr, ans;
    static void twoPointer(int t){
        int start = 0, end = N-1;

        while(start != end-1){
            if(start == t){
                start++;
                continue;
            }else if (end == t){
                end--;
                continue;
            }
            long sum = arr[start]+arr[end];

            if(minimum > Math.min(minimum,Math.abs(arr[t]+sum))) {
                ans[0] = arr[t];
                ans[1] = arr[start];
                ans[2] = arr[end];
                minimum = Math.min(minimum,Math.abs(arr[t]+sum));
            }
            if((arr[t]+sum)>0)
                end--;
            else
                start++;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new long[N];

        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(input[i]);

        Arrays.sort(arr);
        ans = new long[3];
        for (int i = 0 ; i < N ; i++)
            twoPointer(i);

        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 3 ; i++){
            sb.append(ans[i]);
            if(i!=2)
                sb.append(" ");
        }

        System.out.println(sb);
    }
}
