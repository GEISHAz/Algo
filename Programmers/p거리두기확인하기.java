package Programmers;

import java.util.*;

class p거리두기확인하기 {

	char[][] map;
	Queue<Node> q;
	boolean[][] isVisited;
	int[][] d = {{0,1},{1,0},{-1,0},{0,-1}};

	class Node{
		int x;
		int y;
		int dis;
		public Node(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	public int[] solution(String[][] places) {
		List<Integer> answer = new ArrayList<>();
		for(int i = 0 ; i < 5 ; i++){
			//확인 method
			map = new char[5][5];
			trans(places[i]);
			if(check()) answer.add(1);
			else answer.add(0);
		}
		return answer
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	// 확인용이한 char 2차원배열로 바꾸기
	public void trans(String[] place){
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				map[i][j] = place[i].charAt(j);
			}
		}
	}
	//각 좌표확인 P확인되면 BFS 호출
	public boolean check(){
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				if(map[i][j]=='P'){
					if(!BFS(i,j)) //불합격시
						return false;
					else //호출결과 거리 2이하에 P 없으면 모든 P에 대하여 거리확보 좌표제거
						map[i][j]='O';
				}
			}
		}
		return true;
	}
	//BFS로 각 P간의 거리를 확인해보는 method
	//거리가 1 인것만 q에 집어넣는다.
	//거리가 2 이하 하나라도 발견되면 바로 return false
	//좌표마다 초기화가 잘되어야함.
	public boolean BFS(int x, int y){
		isVisited = new boolean[5][5];
		q = new ArrayDeque<>();
		q.add(new Node(x,y,0));
		isVisited[x][y] = true;
		while(!q.isEmpty()){
			Node now = q.poll();

			if(map[now.x][now.y] == 'P' && now.dis != 0){ //거리 2이하만 넣었는데 2이하에 사람이 있다?
				return false; //불합격
			}

			isVisited[now.x][now.y] = true; //체크
			for(int i = 0 ; i < 4 ; i++){
				int afterX = now.x+d[i][0];
				int afterY = now.y+d[i][1];
				//벽넘었거나 들른곳이면 넘어가고
				if(afterX < 0 || afterX > 4 ||
						afterY < 0 || afterY > 4 ||
						isVisited[afterX][afterY] ||
						map[afterX][afterY] == 'X')
					continue;
					//벽 안넘었고 들른곳도 벽도 아닌데 거리가 1이하면 바로 q에 집어넣기
				else if(now.dis <= 1)
					q.add(new Node(afterX,afterY,now.dis+1));
			}
		}
		return true; //합격
	}

}
//내생각에 모든 P를 찾아 BFS를 돌면서 다른 P를 찾는다.
//모든 P의 위치를 싹다 구한다? X 어차피 벽때문에 한번 더 검사해야함

//한대기실에 25개밖에안되니까 한번 싹다 확인해본다? ?
//각 P의 위치에서 맨해튼거리 2이하인곳만 벽없이 갈 수 있는지 확인해본다? O

//맨해튼거리 2이하란 x,y 좌표가 3이상 차이나야한다는소리 결론은 확인해볼곳은 그리 많지않다?
//솔직히말해서 확인해볼곳이 총 내생각에 12자리밖에없다. 확인되면 map에서 지운다? 괜찮네




