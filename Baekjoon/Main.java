import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        Long N = Long.parseLong(br.readLine());
        long[] arr = Arrays
                .stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] pf = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long ans = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            ans += arr[i] / pf[0];
            ans = arr[i] % pf[0] == 0 ? ans : ans+1;
        }
        System.out.println(ans);
        System.out.println(N/pf[1]+" "+N%pf[1]);
    }
}
