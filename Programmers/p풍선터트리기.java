package Programmers;

import java.util.*;

class p풍선터트리기 {
    int[] leftMin,rightMin;

    public int solution(int[] a) {
        int answer = 0;
        int size = a.length;
        leftMin = new int[size];
        rightMin = new int[size];

        leftMin[0] = a[0];
        rightMin[size-1] = a[size-1];

        for(int i = 1 ; i < size ; i++){
            leftMin[i] = Math.min(leftMin[i-1],a[i]);
            rightMin[size-i-1] = Math.min(rightMin[size-i],a[size-i-1]);
        }

        for(int i = 0 ; i < size ; i++){
            if(a[i] <= rightMin[i] || a[i] <= leftMin[i])
                answer++;
        }

        return answer;
    }
}