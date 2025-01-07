package Programmers;

import java.util.*;

class p점프와순간이동 {
    public int solution(int[] people, int limit) {
        int answer = 0, j = people.length-1;
        Arrays.sort(people);
        for(int i = 0 ; i <= j; j--){
            if(people[i]+people[j] <= limit) i++;
            answer++;
        }
        return answer;
    }
}