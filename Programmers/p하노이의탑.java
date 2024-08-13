package Programmers;

import java.util.*;

class p하노이의탑 {
    ArrayList<int[]> list = new ArrayList<>();
    public void hanoi(int n, int from, int mid, int to){
        if(n == 0)
            return;
        hanoi(n-1,from,to,mid);
        list.add(new int[]{from,to});
        hanoi(n-1,mid,from,to);
    }
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(n,1,2,3);
        answer = list.stream().toArray(int[][]::new);
        return answer;
    }
}