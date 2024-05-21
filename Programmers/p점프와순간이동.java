import java.util.*;

public class p점프와순간이동 {
    public int solution(int n) {
        int cnt = 0, num = n;
        while(n != 0)
        {
            if(n%2==1){
                n-=1;
                cnt+=1;
            } else{
                n/=2;
            }
        }
        return cnt;
    }
}
