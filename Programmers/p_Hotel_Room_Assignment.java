package Programmers;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class p_Hotel_Room_Assignment {

    HashMap<Long,Long> status = new HashMap<>();

    public long[] solution(long k, long[] room_number) {

        int len = room_number.length;
        long[] answer = new long[len];

        for(int i = 0 ; i < len ; i++){
            answer[i] = find(room_number[i]);
        }
        return answer;
    }

    long find(long room_num){
        if(!status.containsKey(room_num)){
            status.put(room_num,room_num+1);
            return room_num;
        }
        long empty = find(status.get(room_num));
        status.put(room_num,empty+1);
        return empty;
    }
}