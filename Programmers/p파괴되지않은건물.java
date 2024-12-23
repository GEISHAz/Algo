package Programmers;
import java.util.*;
import java.io.*;

class p파괴되지않은건물 {
	int[][] sum;
	int sizeX,sizeY;
	int calculate(int[][] board, int x, int y){
		int answer = 0;
		for(int i = 0 ; i < x ; i++){
			for(int j = 0 ; j < y ; j++){
				if(board[i][j]+sum[i][j] > 0)
					answer++;
			}
		}
		return answer;
	}
	void prefixSum(int[][] board){
		for(int i = 0 ; i < sum.length-1 ; i++){
			for(int j = 0 ; j < sum[0].length-1 ; j++){
				sum[i][j+1] = sum[i][j+1]+sum[i][j];
			}
		}
		for(int j = 0 ; j < sum[0].length-1 ; j++){
			for(int i = 0 ; i < sum.length-1 ; i++){
				sum[i+1][j] = sum[i+1][j]+sum[i][j];
			}
		}

	}
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		sizeX = board.length;
		sizeY = board[0].length;
		sum = new int[sizeX+1][sizeY+1];
		for(int i = 0 ; i < sizeX+1 ; i++){
			Arrays.fill(sum[i],0);
		}
		for(int[] skillSet : skill){
			int type = (skillSet[0] == 1) ? -1 : 1;
			int degree = skillSet[5];
			int r1 = skillSet[1];
			int c1 = skillSet[2];
			int r2 = skillSet[3];
			int c2 = skillSet[4];
			sum[r1][c1] += degree*type;
			sum[r2+1][c2+1] += degree*type;
			sum[r1][c2+1] += -degree*type;
			sum[r2+1][c1] += -degree*type;
		}

		prefixSum(board);
		return calculate(board,sizeX,sizeY);
	}
}