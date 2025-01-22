package Programmers;

import java.util.*;

class pMaster_of_playing_alone {

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVisited;

        public int solution(int[] cards) {
            int size = cards.length;
            isVisited = new boolean[size];
            for(int i = 0 ; i < size ; i++){
                if(!isVisited[i])
                {
                    int current = i;
                    int count = 0;

                    while(!isVisited[current]){
                        isVisited[current] = true;
                        count++;
                        current = cards[current]-1;
                    }

                    if(current == i){
                        list.add(count);
                    }
                }
            }
            Collections.sort(list,(o1,o2)-> o2 - o1);
            if(list.size() < 2)        return 0;
            return list.get(0)*list.get(1);
        }
    }