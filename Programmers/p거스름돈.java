package Programmers;

import java.util.Arrays;

class p거스름돈 {

	public int solution(int n, int[] money) {
		Arrays.sort(money);

		long[] dp = new long[n+1];

		for(int i =0; i<=n ;i++){
			if(i % money[0] == 0)
				dp[i]=1;
		}

		for(int i=1; i<money.length ; i++){
			for(int j=money[i]; j<=n; j++){
				dp[j] += dp[j-money[i]];
			}
		}

		return (int)(dp[n] % 1000000007);
	}
}