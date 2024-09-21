package Programmers;

// 유니온 파인드
// union method => 묶는역할
//  0   1   2   3
// [0] [1] [2] [3]

// after union 0 1
//  0   1   2   3
// [0] [0] [2] [3]

// after union 2 3
//  0   1   2   3
// [0] [0] [2] [2]

// after union 1 2
//  0   1   2   3
// [0] [0] [0] [2]

// after union 1 2
//  0   1   2   3
// [0] [0] [2] [2]

// after union 0 3
//  0   1   2   3
// [0] [0] [2] [0]

// find 0
// find method => 어느 그룹인지 찾는 역할
import java.util.*;

class p네트워크 {
    private int[] p;
    public int find(int a){
        if(a == p[a]) return p[a];
        return p[a] = find(p[a]);
    }
    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) p[fa]=fb;
    }
    public int solution(int n, int[][] computers) {
        p = new int[n];
        int answer = 0 ,count = 0;
        for(int i = 0 ; i < n ; i++)
            p[i] = i;
        for(int[] arr : computers){
            for(int i = 0 ; i < n ; i++){
                if(i == count || arr[i] == 0) continue;
                if(p[i] != p[count])
                    union(Math.min(i,count),Math.max(i,count));
            }
            count++;
        }
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            s.add(find(p[i]));
        }
        return s.size();
    }
}