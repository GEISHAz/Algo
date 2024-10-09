package Programmers;

// 다익스트라 dijkstra algorithm 최단경로 algorithm
// 반대로 가자.
import java.util.*;

class p가장먼노드 {
    int[] ans;  //최단거리 저장
    boolean[] isVisited; //들렀나?
    ArrayList<Integer>[] map;
    class Node{
        int edge;
        int dis;
        public Node(int edge, int dis){
            this.edge = edge;
            this.dis = dis;
        }
    }
    private void BFS(int n){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(isVisited[now.edge]) continue; // 만약 최단경로아니고 이미들른곳이면 pass
            isVisited[now.edge] = true;
            ans[now.edge] = now.dis;
            for(int i : map[now.edge]){
                if((now.dis+1) < ans[i])
                    q.add(new Node(i,now.dis+1));
            }
        }
    }
    //최대 경로 갯수 몇개
    private int findAnswer(int n){
        int maxValue = Integer.MIN_VALUE;
        int result = 0;
        for(int i = 1 ; i < n ; i++){
            if(maxValue < ans[i]){
                result = 1;
                maxValue = ans[i];
            }else if( maxValue == ans[i]) result++;

        }
        return result;
    }
    public int solution(int n, int[][] edge) {
        ans = new int[n+1];
        isVisited = new boolean[n+1];
        map = new ArrayList[n+1];
        //초기화
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i = 1 ; i <= n ; i++)
            map[i] = new ArrayList<>();
        for(int[] connect : edge){
            map[connect[0]].add(connect[1]);
            map[connect[1]].add(connect[0]);
        }
        BFS(n+1);
        return findAnswer(n+1);
    }
}

// 메모리초과 이차원배열을 arraylist로