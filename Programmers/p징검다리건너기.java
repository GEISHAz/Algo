package Programmers;

import java.util.*;

class p징검다리건너기 {
    private boolean find(int[] stones,int n,int k){
        int check = 0;
        for(int i = 0 ; i < stones.length ; i++){
            if(stones[i] < n) check++;
            else check = 0;
            if(check > k) return false;
        }
        return true;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(stones).max().getAsInt();
        while(start<=end){
            int mid = (start + end) / 2;
            if(find(stones,mid,k-1)){
                answer = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return answer;
    }
}