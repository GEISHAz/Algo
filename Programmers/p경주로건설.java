package Programmers;
import java.util.*;

class p경주로건설 {

	private int answer;

	private class Node{
		int x;
		int y;
		int d;
		int cost;

		public Node(int x, int y, int d, int cost){
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}
	}

	private void bfs(int n, int[][] board){
		Queue<Node> q = new ArrayDeque<>();
		int[][][] isVisited = new int[n + 1][n + 1][4];  // 각 방향 별로 비용을 기록하는 3차원 배열
		int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

		// 초기화
		q.add(new Node(0, 0, -1, 0));
		for (int i = 0; i < 4; i++) {
			isVisited[0][0][i] = 0;  // 출발 지점 비용 초기화
		}

		while(!q.isEmpty()){

			Node now = q.poll();

			if(now.x == n && now.y == n){
				answer = Math.min(answer, now.cost);
				continue;
			}

			for(int d = 0 ; d < 4 ; d++){
				int x = now.x + dir[d][0];
				int y = now.y + dir[d][1];
				int nextCost = now.cost + (now.d == d || now.d == -1 ? 100 : 600);

				// 범위 확인, 장애물 확인, 비용 조건 확인
				if(x >= 0 && x <= n && y >= 0 && y <= n && board[x][y] == 0) {
					if(isVisited[x][y][d] == 0 || isVisited[x][y][d] > nextCost){
						isVisited[x][y][d] = nextCost;
						q.add(new Node(x, y, d, nextCost));
					}
				}
			}
		}
	}

	public int solution(int[][] board) {
		int N = board.length;
		answer = Integer.MAX_VALUE;
		bfs(N - 1, board);
		return answer;
	}
}
