package Programmers;

class p_Number_Block {
	private int isPrime(int n){
		if(n == 1) return 0;
		int max = 1;

		for(int i = 2 ; i <= Math.sqrt(n) ; i++){
			if(n % i == 0){
				if(n / i <= 10000000) return n / i;
				max = i;
			}
		}
		return max;
	}

	public int[] solution(long begin, long end) {
		int[] result = new int[(int)(end - begin + 1)];
		int index = 0;

		for(long i = begin ; i <= end ; i++){
			result[index++] = isPrime((int)i);
		}

		return result;
	}
}