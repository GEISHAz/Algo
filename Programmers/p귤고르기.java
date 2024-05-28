import java.util.*;

class p귤고르기 {
    public int solution(int k, int[] tangerine) {
        int cnt =0 , sum=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());
        for(int v : list){
            if(sum+v>=k){
                cnt++;
                break;
            }
            else{
                sum+=v;
                cnt++;
            }
        }
        return cnt;
    }
}