package Programmers;
import java.util.*;

class p부대복귀 {

    List<Integer>[] graph;
    int[] cost;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        cost = new int[n+1];
        Arrays.fill(cost,-1);

        bfs(destination);

        return Arrays.stream(sources)
                .map(idx->cost[idx])
                .toArray();
    }
    private void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        cost[start] = 0;

        while(!q.isEmpty()){

            int now = q.poll();
            int len = graph[now].size();

            for(int i = 0 ; i < len ; i++){
                int num = graph[now].get(i);
                if(cost[num] == -1){
                    q.add(num);
                    cost[num] = cost[now] + 1;
                }
            }
        }
    }


}