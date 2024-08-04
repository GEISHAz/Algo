class p연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {

        int N = sequence.length;
        int left=0, right = N-1;
        int sum = 0;
        for(int i = 0, j = 0 ; i < N ; i++){
            while(j < N && sum < k){
                sum+= sequence[j];
                j++;
            }
            if(sum == k){
                if((right-left)>(j-i))
                {
                    left = i;
                    right = j;
                }
            }
            sum -= sequence[i];
        }
        int[] answer = {left,right-1};
        return answer;
    }
}