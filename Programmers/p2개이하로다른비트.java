package Programmers;

import java.util.*;

class p2개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0 ; i < numbers.length; i++){
            String str = Long.toBinaryString(numbers[i]);
            if(numbers[i]%2==0)
                answer[i] = numbers[i]+1;
            else {
                int idx = str.lastIndexOf("0");

                if (idx == -1) {
                    String tmp = "10" + str.substring(1, str.length());
                    answer[i] = Long.parseLong(tmp, 2);
                } else {
                    String tmp = str.substring(0, idx) + "10" + str.substring(idx + 2, str.length());
                    answer[i] = Long.parseLong(tmp, 2);
                }
            }
        }
        return answer;
    }
}