import java.util.*;

class p더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        while(pq.peek() < K && pq.size()>=2){
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first+(second*2));
        }
        return pq.peek() >= K ? answer:-1;
    }
}