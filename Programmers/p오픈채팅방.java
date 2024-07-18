package Programmers;

import java.util.*;

class p오픈채팅방 {
    public String[] solution(String[] record) {

        ArrayList<String> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        for(String str : record){
            String[] three = str.split(" ");
            if(three[0].equals("Enter")){
                list.add(three[1]+" 들어왔습니다.");
                map.put(three[1],three[2]);
            }
            else if(three[0].equals("Leave"))
                list.add(three[1]+" 나갔습니다.");
            else
                map.put(three[1],three[2]);
        }
        for(int i = 0 ; i < list.size() ; i++){
            String s = list.get(i).split(" ")[0];
            list.set(i,list.get(i).replaceAll(s,map.get(s)+"님이"));
        }
        String[] answer = new String[list.size()];
        return list.toArray(answer);

    }
}