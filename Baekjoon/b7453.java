import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b7453 {
    static int N;

    static int lowerBound(long target, long[] B) {
        int left = 0;
        int right = B.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= B[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(long target, long[] B) {
        int left = 0;
        int right = B.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < B[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] input = new long[4][N];
        long[] A = new long[N * N];
        long[] B = new long[N * N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[0][i] = Integer.parseInt(st.nextToken());
            input[1][i] = Integer.parseInt(st.nextToken());
            input[2][i] = Integer.parseInt(st.nextToken());
            input[3][i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[count] = input[0][i] + input[1][j];
                B[count++] = input[2][i] + input[3][j];
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        long answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) continue;
            int leftA = lowerBound(A[i], A);
            int rightA = upperBound(A[i], A);
            int leftB = lowerBound(-A[i], B);
            int rightB = upperBound(-A[i], B);
            answer += (long)(rightA - leftA) * (rightB - leftB);
            i = rightA - 1;
        }
        System.out.println(answer);
    }
}
