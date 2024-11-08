import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int[] getArr(int N){
        boolean[] isPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = getArr(N);
        int size = arr.length, sum = 0, answer = 0;

        for(int start = 0 ; start < size ; start++){
            sum = arr[start];
            if(sum == N){
                answer++;
                continue;
            }
            for(int end = start + 1 ; end < size ; end++){
                sum+=arr[end];
                if(sum > N) break;
                if(sum == N){
                    answer ++;
                    break;
                }

            }
        }
        System.out.println(answer);
    }
}