package Programmers;

import java.util.*;

class p합승택시요금 {

    int[][] allToAll;
    int INF = Integer.MAX_VALUE;

    void floydWarshall(int n){
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(allToAll[j][i] != INF && allToAll[i][k] != INF )
                        allToAll[j][k]=Math.min(allToAll[j][k],allToAll[j][i]+allToAll[i][k]);
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        int answer = INF;
        allToAll = new int[n+1][n+1];

        //초기화
        for(int i = 0 ; i < n+1 ; i++){
            Arrays.fill(allToAll[i],INF);
            allToAll[i][i] = 0;
        }
        for(int i = 0 ; i < fares.length; i++){
            allToAll[fares[i][0]][fares[i][1]] = fares[i][2];
            allToAll[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        floydWarshall(n);
        // 제대로 계산되었다면 여기서 answer은 각각 따로 택시타고 가는 요금이 나옴
        answer = allToAll[s][a] + allToAll[s][b];
        for(int i = 1 ; i <= n ; i++){
            answer = Math.min(answer,allToAll[s][i]+allToAll[i][a]+allToAll[i][b]);
        }
        return answer;
    }
}