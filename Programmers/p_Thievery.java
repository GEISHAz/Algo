package Programmers;

class p_Thievery {
	int[] dp1,dp2;
	public int solution(int[] money) {
		int size = money.length;
		dp1 = new int[size+1];
		dp2 = new int[size+1];
		dp1[0] = 0;
		dp2[0] = 0;
		for(int i = 0 ; i < size-1 ; i++){
			dp1[i+1] = money[i];
			dp2[i+1] = money[i+1];
		}
		for(int i = 2 ; i < dp1.length ; i++){
			dp1[i] = Math.max(dp1[i-1],dp1[i-2]+dp1[i]);
			dp2[i] = Math.max(dp2[i-1],dp2[i-2]+dp2[i]);
		}
		return Math.max(dp1[size-1],dp2[size-1]);
	}
}