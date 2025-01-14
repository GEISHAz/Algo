package Programmers;
import java.util.*;
import java.io.*;

class p_Oil_Drilling {
    class Oil{
        int start;
        int end;
        int size;
        public Oil(int start,int end, int size){
            this.start = start;
            this.end = end;
            this.size = size;
        }
    }
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Oil> list = new ArrayList<>();
    boolean[][] isVisited;
    int N,M;
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};


    void bfs(int x, int y, int[][] land){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y));
        isVisited[x][y] = true;
        int count = 1, minY = y, maxY = y;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d = 0; d < 4; d++){
                int dx = node.x+dir[d][0];
                int dy = node.y+dir[d][1];
                if(dx >= 0 && dx < N && dy >= 0 && dy < M &&
                        !isVisited[dx][dy] && land[dx][dy] == 1){
                    count++;
                    q.add(new Node(dx,dy));
                    isVisited[dx][dy] = true;
                    minY = Math.min(minY,dy);
                    maxY = Math.max(maxY,dy);
                }
            }
        }
        list.add(new Oil(minY,maxY,count));
    }

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        isVisited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!isVisited[i][j] && land[i][j]==1){
                    bfs(i,j,land);
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < M ; i++){
            int cnt = 0;
            for(int j = 0 ; j < list.size(); j++){
                Oil o = list.get(j);
                if(o.start <= i && o.end >= i)
                    cnt += o.size;
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
}