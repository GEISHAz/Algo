import java.util.*;

class p두큐합같게만들기 {
    public long solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum1=0,sum2=0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int a : queue1){
            sum1+=a;
            q1.add(a);
        }
        for(int a : queue2){
            sum2+=a;
            q2.add(a);
        }
        if(sum1+sum2 % 2 ==1)
            return -1;
        long cnt = 0;
        int num;
        while(cnt <= queue1.length*4)
        {
            if(sum1 == sum2){
                return cnt;
            }
            else if(sum1>sum2)
            {
                num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            }
            else{
                num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.add(num);
            }
            cnt++;
        }
        return -1;
    }
}