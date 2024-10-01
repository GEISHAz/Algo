package Programmers;
//Queue 사용해서 하면될듯
// Node 사용
import java.util.*;

class p다리를지나는트럭 {

    private int b_weight = 0;
    private ArrayDeque<Node> q = new ArrayDeque<>();

    class Node{
        int weight;
        int time;
        public Node(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    private int takeOff(int bridge_length,int time){
        Node n = q.poll();
        b_weight -= n.weight;
        return bridge_length - (time - n.time);
    }
    private void takeOn(int truck,int time){
        b_weight += truck;
        q.add(new Node(truck,time));
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0,time = 0;

        for(int truck : truck_weights){
            while (!q.isEmpty() && (time - q.peek().time >= bridge_length)) {
                b_weight -= q.poll().weight;
            }
            if(weight < truck + b_weight){ // 만약 다리중량 X
                while(weight < truck + b_weight){
                    time += takeOff(bridge_length,time);
                }
                takeOn(truck,time);
            }
            else{
                time++;
                takeOn(truck,time);
            }
        }
        answer = q.peekLast().time+bridge_length;
        return answer;
    }
}