import java.io.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int answer = 0;
        int left = 1 , right = M;
        while(left<=right){
            int mid = (left+right)/2;
            int cnt = 0;
            for(int i = 1 ; i <= N ; i++)
                cnt+= Math.min(mid/i,N);
            if (M > cnt){
                left = mid+1;
            }else{
                right = mid-1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
