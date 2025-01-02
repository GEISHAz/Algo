import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, answer = 0;
    static int[][] board, saved;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void merge() {
        for (int i = 0; i < N; i++) {
            int[] arr = new int[N];
            int idx = 0;
            for (int n : saved[i]) {
                if (n != 0) arr[idx++] = n;
            }
            for (int j = 0; j < N - 1; j++) {
                if (arr[j] == arr[j + 1]) {
                    arr[j] *= 2;
                    arr[j + 1] = 0;
                    j++;
                }
            }
            int[] ans = new int[N];
            idx = 0;
            for (int n : arr) {
                if (n != 0) ans[idx++] = n;
            }
            saved[i] = ans;
        }
    }

    static void rotate() {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                rotated[N - j - 1][i] = saved[i][j];
        saved = rotated;
    }

    static void flip() {
        int[][] fliped = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                fliped[N - i - 1][N - j - 1] = saved[i][j];
        saved = fliped;
    }

    static void applyDirection(int dir) {
        if (dir == 1) {
            merge();
        } else if (dir == 2) {
            flip();
            merge();
            flip();
        } else if (dir == 3) {
            rotate();
            merge();
        } else if (dir == 4) {
            flip();
            rotate();
            merge();
            rotate();
        }
    }

    static void combination(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++)
                for (int m : saved[i])
                    answer = Math.max(answer, m);
            return;
        }
        int[][] original = new int[N][N];
        for (int i = 0; i < N; i++) {
            original[i] = saved[i].clone();
        }
        for (int dir = 1; dir <= 4; dir++) {
            applyDirection(dir);
            combination(depth + 1);
            saved = original;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }
        saved = new int[N][N];
        for (int i = 0; i < N; i++) {
            saved[i] = board[i].clone();
        }
        combination(0);
        System.out.println(answer);
    }
}
