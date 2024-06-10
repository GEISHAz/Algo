import java.util.*;

class p기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        int max = -1000, memory = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < progresses.length ; i++ ){
            if((100 - progresses[i]) % speeds[i] == 0)
                q.add((100 - progresses[i]) / speeds[i]);
            else
                q.add((100 - progresses[i]) / speeds[i] + 1);
        }

        while(!q.isEmpty()){
            if(max >= q.peek()){
                memory += 1;
                q.poll();
            }
            else{
                if(memory != 0){
                    resultList.add(memory);
                    memory = 0;
                }
                max = q.peek();
                memory = 1;
                q.poll();
            }
        }

        resultList.add(memory);

        int[] answer = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
