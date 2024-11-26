package Programmers;

import java.util.*;

class p셔틀버스 {

    private ArrayList<Integer> list;

    public String solution(int n, int t, int m, String[] timetable) {
        list = new ArrayList<>();

        for (String time : timetable) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            list.add(hour * 60 + minute);
        }

        Collections.sort(list);

        int index = 0;
        int answer  = 540+(n-1)*t;

        for(int i = 0 ; i < n ; i++){
            int busTime = 540 + (i * t);
            int capacity = m;

            while(list.size() > index && capacity > 0 && list.get(index) <= busTime){
                index++;
                capacity--;
            }


            if(i == n - 1){
                if (capacity > 0) {
                    answer = busTime;
                } else {
                    answer = list.get(index - 1) - 1;
                }
            }
        }

        return String.format("%02d:%02d",answer / 60,answer % 60);
    }
}