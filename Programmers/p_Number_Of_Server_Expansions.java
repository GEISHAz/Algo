package Programmers;

import java.util.*;

class p_Number_Of_Server_Expansions {
	public int solution(int[] players, int m, int k) {
		int[][] server = new int[2][24];
		Arrays.fill(server[0],0); // 현재 서버 댓수
		Arrays.fill(server[1],0);
		for(int i = 0 ; i < 24 ; i++){
			int nowNeed = players[i] / m;
			int nowCom = server[0][i];
			if(nowNeed > nowCom){ // 증설이 필요
				int upgrade = nowNeed - nowCom;
				server[1][i] = (i==0) ? nowNeed : server[1][i-1] + upgrade;
				for(int j = i ; j < i+k ; j++){
					if(j <= 23){
						server[0][j] = server[0][j] + upgrade;
					}else{
						break;
					}
				}
			}else{ // 증설 필요 없음
				server[1][i] = (i==0) ? nowNeed : server[1][i-1];
			}
		}
		return server[1][23];
	}
}