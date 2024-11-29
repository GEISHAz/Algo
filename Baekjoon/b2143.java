import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2143 {

    static int an, bn, t;
    static int[] A, B;
    static int[] aSum, bSum;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        an = Integer.parseInt(br.readLine());
        A = parseArray(br.readLine(), an);
        bn = Integer.parseInt(br.readLine());
        B = parseArray(br.readLine(), bn);

        Thread t1 = new Thread(()->{
            aSum = calculateSubarraySums(A, an);
        });
        Thread t2 = new Thread(()->{
            bSum = calculateSubarraySums(B, bn);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long result = calculatePairCount(aSum, bSum, t);

        System.out.println(result);
    }

    static int[] parseArray(String input, int size) {
        int[] array = new int[size];
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return array;
    }

    static int[] calculateSubarraySums(int[] array, int size) {
        int[] subarraySums = new int[size * (size + 1) / 2];
        int index = 0;

        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += array[j];
                subarraySums[index++] = sum;
            }
        }

        return subarraySums;
    }

    static long calculatePairCount(int[] aSum, int[] bSum, int target) {
        int left = 0, right = bSum.length - 1;
        long count = 0;

        while (left < aSum.length && right >= 0) {
            long asv = aSum[left], bsv = bSum[right];
            long sum = asv + bsv;

            if (sum == target) {
                long ac = 0, bc = 0;

                while (left < aSum.length && aSum[left] == asv) {
                    left++;
                    ac++;
                }

                while (right >= 0 && bSum[right] == bsv) {
                    right--;
                    bc++;
                }

                count += ac * bc;

            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return count;
    }
}
