import java.util.*;

class p모음사전 {
    List<String> list = new ArrayList<>();
    String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        DFS("",0);
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public void DFS(String w,int depth){
        list.add(w);
        if(depth == 5)
            return;
        for(int i = 0 ; i < 5 ; i++){
            DFS(w+arr[i],depth+1);
        }
    }
}