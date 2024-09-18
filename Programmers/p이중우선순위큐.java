package Programmers;
// 차례대로 반복문 돌린다.
// 들어온 string에 l, D 1 , D -1 의 명령어 분기처리
// 최대 최소 priority queue 0과 끝자리 탐색 해서 return  || 없으면 0,0 반환

// 명령어 분기
// I 삽입
// D 1 최대 삭제
// D -1 최소 삭제
import java.util.*;

class p이중우선순위큐 {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    public void action(String str){
        if(str.contains("D")){
            if(pq.isEmpty()) return;
            if(str.contains("-1")) //최소삭제
                pq.poll();
            else{ //최대삭제
                int removeElement = pq.stream().max(Integer::compareTo).get();
                pq.remove(removeElement);
            }
        }
        else
            pq.add(Integer.parseInt(
                    str.substring(2,
                            str.length())));

    }
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        for(String s : operations)
            action(s);
        if(pq.isEmpty()) return answer;
        answer[0] = pq.stream().max(Integer::compareTo).orElse(null);
        answer[1] = pq.peek();
        System.out.println(answer[0]+" "+answer[1]);
        return answer;
    }
}
// 위코드는 최소는 비교적쉽게 제거하나 최대는 stream()으로 순회하여 확인하고 찾아낸다.

    // 아래의 코드는 두개의 우선순위큐를 사용하여 해결한 문제다.    보다 효율적이다.

//import java.util.*;
//
//class Solution {
//    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
//    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
//
//    public void action(String str){
//        if(str.startsWith("I")) {
//            int number = Integer.parseInt(str.substring(2));
//            minHeap.add(number);
//            maxHeap.add(number);
//        } else if (!minHeap.isEmpty()) {
//            if(str.equals("D 1")) {
//                // 최대 힙에서 최대 요소 삭제
//                int max = maxHeap.poll();
//                minHeap.remove(max);
//            } else if (str.equals("D -1")) {
//                // 최소 힙에서 최소 요소 삭제
//                int min = minHeap.poll();
//                maxHeap.remove(min);
//            }
//        }
//    }
//
//    public int[] solution(String[] operations) {
//        for(String operation : operations) {
//            action(operation);
//        }
//
//        int[] answer = new int[2];
//        if (!minHeap.isEmpty()) {
//            answer[0] = maxHeap.peek();
//            answer[1] = minHeap.peek();
//        }
//        return answer;
//    }
//}