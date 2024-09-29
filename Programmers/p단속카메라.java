package Programmers;

//들어오는 route 별
//정렬 먼저할까?
//start 지점이 낮은순 end가 높은순
//하나씩의 node를 불러오면서 만약 새로운 answer list안의 노드범위안에 들지않으면 새로운 감시카메라 생성
// 해당한다면 기존 answerlist의 노드범위를 조정

//import java.util.*;
//
//class p단속카메라 {
//    class Node{
//        int start;
//        int end;
//        public Node(int start, int end){
//            this.start = start;
//            this.end = end;
//        }
//    }
//    private int check(Node n, List<Node> answer){
//        for(int i = 0 ; i < answer.size() ; i++){
//            if((answer.get(i).start <= n.start
//                    && answer.get(i).end >= n.start) ||
//                    (answer.get(i).start <= n.end
//                            && answer.get(i).end >= n.end))
//                return i;
//        }
//        return -1;
//    }
//    public int solution(int[][] routes) {
//
//        List<Node> list = new ArrayList<>();
//
//        for(int[] route : routes)
//            list.add(new Node(route[0],route[1]));
//
//        //정렬
//        Collections.sort(list,(n1,n2)->{
//            if(n1.start==n2.start)
//                return n2.end-n1.end;
//            return n1.start - n2.start;
//        });
//
//        List<Node> answer = new ArrayList<>();
//        for(Node n : list){
//            int after = check(n,answer);
//            if(after == -1)
//                answer.add(n);
//            else{
//                answer.set(after,new Node(Math.max(answer.get(after).start,n.start),
//                        Math.min(answer.get(after).end,n.end)));
//            }
//        }
//        return answer.size();
//    }
//}

// GPT의 답변

import java.util.*;

class p단속카메라 {
    public int solution(int[][] routes) {
        // 진출 지점을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameras = 0;
        int lastCameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 차량의 진입 지점이 마지막 카메라 위치를 넘어섰다면
            if (lastCameraPosition < route[0]) {
                cameras++; // 새로운 카메라 설치
                lastCameraPosition = route[1]; // 카메라 위치 갱신
            }
        }

        return cameras;
    }
}