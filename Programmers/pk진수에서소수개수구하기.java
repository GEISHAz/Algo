import java.util.*;

class pk진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n,k);
        String[] numbers = number.split("0");
        for(String s : numbers){
            if(s.equals("")) continue;
            Long a = Long.parseLong(s);
            boolean find = true;
            if(a==1) continue;
            for(int i = 2; i <= Math.sqrt(a); i++){
                if(a%i==0){
                    find = false;
                    break;
                }
            }
            if(find) answer++;
        }
        return answer;
    }
}