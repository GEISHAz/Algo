package Programmers;

import java.util.*;

class pn제곱배열자르기 {
    public  List<Long> solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }
        return list;
    }
}
