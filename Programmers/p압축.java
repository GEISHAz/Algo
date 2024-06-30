import java.util.*;

class p압축 {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> dic = new HashMap<>();

        for(int i = 0 ; i < 26; i++){
            dic.put(String.valueOf((char)('A'+i)),i+1);
        }
        String a = "";
        int dicIndex=27;
        for(int i = 0 ; i<msg.length(); i++){
            String c = String.valueOf(msg.charAt(i));
            if(dic.containsKey(a+c)){
                a+=c;
                continue;
            }
            dic.put(a+c,dicIndex++);
            answer.add(dic.get(a));
            a=c;

        }
        if (!a.equals("")) {
            answer.add(dic.get(a));
        }
        return answer;
    }
}