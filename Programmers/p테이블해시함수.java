package Programmers;

import java.util.*;

class p테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < data.length ; i++){
            int[] arr = new int[data[i].length];

            for(int j = 0 ; j < data[0].length ; j ++)
                arr[j] = data[i][j];

            list.add(arr);
        }

        Collections.sort(list,(o1,o2)->{
            if(o1[col-1]==o2[col-1])
                return o2[0]-o1[0];
            return o1[col-1]-o2[col-1];
        });
        for(int i = row_begin-1 ; i < row_end ; i++){
            int sum = 0 ;
            for(int a : list.get(i)){
                sum += a % (i+1);
            }
            answer = answer ^ sum;
        }
        return answer;
    }
}