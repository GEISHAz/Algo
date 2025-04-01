import java.io.*;
import java.util.*;

public class Main {

    static int N,target,answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = N-1;

        while (left<right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                left++;
                answer++;
                right--;
            }
            else if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }
        }

        System.out.println(answer);




    }
}