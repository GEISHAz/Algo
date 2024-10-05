package Programmers;

// 투포인터 로 풀이 한다.
// 시작과 끝에 포인터 위치
// 우선 모든 gems 배열 돌면서 각 보석이 몇개가 있는지
// map 에 저장하면서 파악
// 끝에서부터 우선 8개가 떨어지지않는 최소위치 파악
// 시작부터 우선 종류가떨어지지않는 최대 위치 파악
// 이건안되고

// 시작점 끝점 1로 고정하면서 End 늘려나간다.
// end 늘렸을 때 모든 보석 포함하고 있다면 시작점이동하면서 최소구간 찾고 최소구간 찾을 시 start end 지점 갱신 ㅇㅋ

import java.util.*;


class p보석쇼핑 {
    public int[] solution(String[] gems) {
        HashSet<String> unique = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String gem : gems)
            unique.add(gem);
        final int kindCount = unique.size();
        int start = 0, minAns = Integer.MAX_VALUE;
        int ansS=0,ansE=0;
        // System.out.println("###start check###");
        // System.out.println("kindCount = "+kindCount);
        // System.out.println("start = "+start);
        // System.out.println("minAns = "+minAns);
        // System.out.println("ansS = "+ansS);
        // System.out.println("ansE = "+ansE);

        //보석 넣기
        for(int i = 0 ; i < gems.length ; i++){
            // System.out.println("i = "+i);
            // System.out.println("minAns = "+minAns);
            // System.out.println("start = "+start);
            // end 늘리기
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
            if(map.size() == kindCount){ // 체크,start 올리기,갱신
                while(map.size() == kindCount){
                    if(map.get(gems[start]) == 1)
                        break;
                    else
                        map.put(gems[start],map.get(gems[start])-1);
                    start++;
                }
                if(minAns != Math.min(i-start,minAns)){
                    // System.out.println("갱신중 = "+(i-start));
                    minAns = Math.min(i-start,minAns);
                    ansS = start;
                    ansE = i;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] =ansS+1;
        answer[1] =ansE+1;
        return answer;
    }
}