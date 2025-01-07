import java.util.*;

class p의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String[] str : clothes) {
            if (!map.containsKey(str[1]))
                map.put(str[1], 1);
            else
                map.put(str[1], map.get(str[1])+1);
        }
        for (Integer value : map.values()){
            answer *= value + 1;
        }
        return answer - 1;
    }
}