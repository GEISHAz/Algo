package Programmers;
import java.util.*;

class p입국심사 {
    //time 들어오면 그 시간에 몇명 가능
    private long calculate(int[] times, long time){
        long sum = 0;
        for(int i = 0 ; i < times.length; i++)
            sum += time / times[i];
        return sum ;
    }
    // 시작과 끝이 정해지면 이분탐색
    private long binarySearch(int n, int[] times){
        Arrays.sort(times);
        long end = times[times.length-1] * (long)n;
        long start = 0, answer = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long cal = calculate(times,mid);
            if(cal < n){
                start = mid + 1;
            }else{
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
}