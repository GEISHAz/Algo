package Programmers;

class pN_Queen {

	int n, answer = 0;

	int howManyLeft(boolean[][] board){
		int value = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++)
				if(!board[i][j]) value++;
		}
		return value;
	}

	boolean[][] checkBoard(int x, int y, boolean[][] origin){
		boolean[][] board = new boolean[n][n];
		for(int i = 0 ; i < n ; i++)
			board[i] = origin[i].clone();

		for(int i = 0 ; i < n ; i++){
			board[x][i] =true;
			board[i][y] =true;
		}
		for(int i = 1 ; i < n ; i++){
			if(x-i >= 0 && y-i >= 0 && !board[x-i][y-i]){ board[x-i][y-i]=true;}
			if(x-i >= 0 && y+i < n && !board[x-i][y+i]){ board[x-i][y+i]=true;}
			if(x+i < n && y-i >= 0 && !board[x+i][y-i]){ board[x+i][y-i]=true;}
			if(x+i < n && y+i < n && !board[x+i][y+i]){ board[x+i][y+i]=true;}
		}
		return board;
	}

	void dfs(int depth, boolean[][] board){
		if(depth == n){
			answer++;
			return;
		}
		if(n-depth > howManyLeft(board)) return;
		for(int j = 0 ; j < n ; j++){
			if(!board[depth][j]) {
				dfs(depth+1,checkBoard(depth,j,board));
			}
		}
	}

	public int solution(int n) {
		this.n = n;
		boolean[][] board = new boolean[n][n];
		dfs(0,board);
		return answer;
	}
}