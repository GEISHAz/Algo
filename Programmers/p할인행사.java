import java.util.*;

public class p할인행사 {
    public static HashMap<String,Integer> wantMap = new HashMap<>();
    public static HashMap<String,Integer> nowMap = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {


        int answer = 0;
        boolean available = true;


        for(int i = 0 ; i < want.length ; i++)
            wantMap.put(want[i],number[i]);

        for(int i = 0 ; i < 10 ; i++)
            nowMap.put(discount[i], nowMap.getOrDefault(discount[i],0)+1);

        available = check(want);

        if(available)
            answer++;

        for(int i = 10 ; i < discount.length ; i++){

            nowMap.put(discount[i],nowMap.getOrDefault(discount[i],0)+1);

            nowMap.put(discount[i-10],nowMap.getOrDefault(discount[i-10],0)-1);

            if(wantMap.getOrDefault(discount[i-10],0) > nowMap.get(discount[i-10])
                    || wantMap.getOrDefault(discount[i],0) > nowMap.get(discount[i]))
            {
                available = false;
                continue;
            }
            else
                available = check(want);
            if(available)
                answer++;
        }
        return answer;
    }
    public static boolean check(String[] want){
        for(int i = 0 ; i < want.length; i++){
            if(wantMap.get(want[i])>nowMap.getOrDefault(want[i],0)){
                return false;
            }
        }
        return true;
    }

}