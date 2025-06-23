import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class b11057 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for(int i = 0 ; i < 10 ; i++){
            dp[1][i] = 10-i;
        }
        for(int i = 0 ; i <= N ; i++){
            dp[i][9] = 1;
        }

        for(int i = 2; i <= N ; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i-1][j]+dp[i][j+1])%10007;
            }
        }
        System.out.println(dp[N][0]);
    }
}


// 0 일때 0

// 1 일때 10  >> 9 8 7 6 5 4 3 2 1 0

// 2 일때 55  >>
//  00 01 02 03 04 05 06 07 08 09  10
//  11 12 13 14 15 16 17 18 19      9
//  22 23 24 25 26 27 28 29         8
//  33 34 35 36 37 38 39            7
//  44 45 46 47 48 49               6
//  55 56 57 58 59                  5
//  66 67 68 69                     4
//  77 78 79                        3
//  88 89                           2
//  99                              1

// 3 일때 220

//    1                           1
//    1 2                         3
//    1 2 3                       6
//    1 2 3 4                     10
//    1 2 3 4 5                   15
//    1 2 3 4 5 6                 21
//    1 2 3 4 5 6 7               28
//    1 2 3 4 5 6 7 8             36
//    1 2 3 4 5 6 7 8 9           45
//    1 2 3 4 5 6 7 8 9 10        55

// dp[i][j] 길이가 i 이고 끝자리 j 인것의 갯수
//    0   1   2   3   4   5   6   7   8   9
//0   0   0   0   0   0   0   0   0   0   0
//1   10  9   8   7   6   5   4   3   2   1
//2   55  45  36  28  21  15  10  6   3   1
//3   220 165 120 84  56  35  20  10  4   1

