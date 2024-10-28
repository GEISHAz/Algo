package Programmers;

import java.util.*;

class p섬연결하기 {
    private int[] p;
    private int find(int a){
        if(p[a]==a) return a;
        return p[a] = find(p[a]);
    }
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) p[b] = a;
    }
    public int solution(int n, int[][] costs) {
        p = new int[n];
        for(int i = 0 ; i < n ; i++)
            p[i] = i;

        Arrays.sort(costs,(o1,o2)-> o1[2]-o2[2] );
        int answer = 0;
        for(int i = 0 ; i < costs.length ; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}