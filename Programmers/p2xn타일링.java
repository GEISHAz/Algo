package Programmers;

class p2xn타일링 {
    public int solution(int n) {
        int[] arr = new int[n+1];
        if(n <= 3)
            return n;
        for(int i = 0 ; i <= n ;i++)
        {
            if(i<=3){
                arr[i] = i;
                continue;
            }
            arr[i]=(arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n];
    }
}