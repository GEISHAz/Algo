package Programmers;

import java.util.*;

class p호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    return o1[0].compareTo(o2[0]);
            }
        });
        int[][] time = new int[book_time.length][2];
        int i = 0;
        ArrayList<Integer> rooms = new ArrayList<>();
        for(String[] o : book_time){
            Collections.sort(rooms);
            String[] start = o[0].split(":");
            String[] end = o[1].split(":");
            time[i][0] = (Integer.parseInt(start[0])*60)+Integer.parseInt(start[1]);
            time[i][1] = (Integer.parseInt(end[0])*60)+Integer.parseInt(end[1])+10;
            boolean isAdded = false;
            for(int j = 0; j<rooms.size(); j++){
                if(rooms.get(j) <= time[i][0]){
                    rooms.set(j,time[i][1]);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                rooms.add(time[i][1]);
            }
            i++;
        }
        return rooms.size();
    }
}