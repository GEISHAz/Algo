import java.util.*;

public class p캐시 {
    LinkedList<String> list = new LinkedList<>();
    int answer = 0;
    public int solution(int cacheSize, String[] cities) {

        if(cacheSize==0)
            return cities.length*5;

        for(String str : cities){
            str = str.toLowerCase();
            if(list.contains(str)){
                answer+=1;
                list.remove(str);
                list.add(str);
            }else{
                if(list.size() == cacheSize ){
                    list.remove(0);
                }
                list.add(str);
                answer+=5;
            }
        }
        return answer;
    }

}