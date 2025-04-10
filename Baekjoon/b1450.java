import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b1450 {

    static int N, C;
    static int[] weights;
    static ArrayList<Long> left;
    static ArrayList<Long> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        C = toInt(st.nextToken());
        left = new ArrayList<>();
        right = new ArrayList<>();

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            weights[i] = toInt(st.nextToken());

        Arrays.sort(weights);

        sumCombination(0,N/2,left,0);
        sumCombination(N/2,N,right,0);

        Collections.sort(right);

        long count = 0;
        for(long sumL : left ){
            if(sumL > C) continue;
            long remain = C - sumL;
            int idx = upperBound(right,remain);
            count += idx;
        }
        System.out.println(count);

    }

    private static void sumCombination(int start, int end, ArrayList<Long> list, long sum) {
        if(end == start){
            if(sum <= C)
                list.add(sum);
            return;
        }
        sumCombination(start + 1, end, list, sum);
        sumCombination(start + 1, end, list, sum+weights[start]);
    }

    private static int upperBound(ArrayList<Long> list, long remain) {
        int leftIdx = 0, rightIdx = list.size();
        while(leftIdx < rightIdx){
            int mid = (leftIdx + rightIdx) / 2;
            if(list.get(mid) <= remain){
                leftIdx = mid + 1;
            }else rightIdx = mid;
        }
        return leftIdx;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}