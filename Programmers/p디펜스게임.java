import java.util.*;

class p디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0, result = n, chance = k;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int enemyCount : enemy){
            result-=enemyCount;
            pq.add(enemyCount);
            while(result < 0 && chance > 0){
                if(!pq.isEmpty()){
                    result += pq.poll();
                    chance--;
                }
            }
            if(result<0)
                break;
            answer++;
        }
        return answer;
    }
}