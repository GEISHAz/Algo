package Programmers;

import java.util.*;

class p메뉴리뉴얼 {
    Map<String,Integer> map = new HashMap<>();
    int max = 0 ;
    public void DFS (String order, int index, String key, int end,int depth){
        if(end == depth){
            map.put(key,map.getOrDefault(key,0)+1);
            max = Math.max(map.get(key),max);
        }
        for(int i = index + 1 ; i < order.length() ; i++){
            DFS(order,i,key+order.charAt(i),end,depth+1);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        for(int c : course){
            map = new HashMap<>();
            max = 0;
            for(String or: orders){
                char[] o = or.toCharArray();
                Arrays.sort(o);
                String order = new String(o);
                DFS(order,-1,"",c,0);
            }
            for(String key : map.keySet()){
                int value = map.get(key);
                if(value > 1 && max == value)
                    ans.add(key);
            }
        }
        Collections.sort(ans);
        String[] answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
}