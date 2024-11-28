package Programmers;

import java.util.*;

class p다단계칫솔판매 {
    Map<String,String> relation;
    Map<String,Integer> money;

    void distribute(String name, int profit){
        int commission = profit/10;
        String next = relation.get(name);
        money.put(name,money.get(name)+(profit-commission));
        if(commission == 0 || next.equals("center"))
            return ;
        distribute(next,commission);

    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        relation = new HashMap<>();
        money = new HashMap<>();
        money.put("center",0);

        //관계저장, 이익 초기화
        for(int i = 0 ; i < enroll.length ; i++){
            money.put(enroll[i],0);
            if(referral[i].equals("-")){
                relation.put(enroll[i],"center");
                continue;
            }
            relation.put(enroll[i],referral[i]);
        }

        for(int i = 0 ; i < seller.length; i++)
            distribute(seller[i],amount[i]*100);


        return Arrays.stream(enroll)
                .mapToInt(a->money.get(a))
                .toArray();
    }
}
