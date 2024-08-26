package Programmers;

import java.util.*;

class p무인도여행 {

    int[][] map;
    boolean[][] isVisited;
    int[][] d = {{-1,0},{0,-1},{1,0},{0,1}};

    class Node{
        int dx;
        int dy;
        public Node(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }
    }

    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        int x = maps.length;
        int y = maps[0].length();

        // 모든 지도 활성화 (char -> int 변환 및 'X'를 0으로 처리)
        map = new int[x][y];
        isVisited = new boolean[x][y];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                char c = maps[i].charAt(j);
                if(c == 'X'){
                    map[i][j] = 0; // 'X'는 생존 불가능 지역이므로 0
                    isVisited[i][j] = true; // 'X'는 방문 처리
                } else {
                    map[i][j] = c - '0'; // 숫자는 그대로 int 변환
                }
            }
        }

        // 순차 체크 (isVisited[][] false 이면 BFS 호출)
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(!isVisited[i][j] && map[i][j] != 0){ // 방문하지 않았고, 0이 아닌 곳만 BFS
                    answer.add(BFS(i, j));
                }
            }
        }

        if(answer.size() == 0)
            answer.add(-1);

        int[] r = answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(r);
        return r;
    }

    // BFS 메서드 BFS로 현재 연결된 무인도의 총 생존 가능 일수 확보 및 isVisited 체크
    public int BFS(int i, int j){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(i, j));
        isVisited[i][j] = true;
        int sum = 0;

        while(!q.isEmpty()){
            Node n = q.poll();
            sum += map[n.dx][n.dy]; // 생존 일수 합산

            for(int k = 0 ; k < 4 ; k++){
                int nx = n.dx + d[k][0];
                int ny = n.dy + d[k][1];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !isVisited[nx][ny] && map[nx][ny] != 0){
                    q.add(new Node(nx, ny));
                    isVisited[nx][ny] = true; // 큐에 넣을 때 방문 처리
                }
            }
        }
        return sum;
    }
}
