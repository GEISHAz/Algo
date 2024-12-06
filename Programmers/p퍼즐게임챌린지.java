package Programmers;

import java.util.ArrayList;
import java.util.List;

class p퍼즐게임챌린지 {
    boolean calculate(int level,int[] diffs, int[] times, long limit){
        long playTime = 0;
        for(int i = 0 ; i < diffs.length ; i++){
            if(limit < playTime) return false;
            if(level < diffs[i])
                playTime += (long)(diffs[i]-level)*(long)(times[i-1]+times[i]);
            playTime += times[i];

        }
        if(limit < playTime) return false;
        return true;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1000000;
        int right = -1;
        for(int i = 0 ; i < diffs.length ; i++){
            right = Math.max(right,diffs[i]);
            left = Math.min(left,diffs[i]);
        }
        while(left<right){
            int mid = (left + right) / 2;
            if(calculate(mid,diffs,times,limit)){
                right = mid;
            }
            else left = mid + 1;
        }
        return right;
    }
}