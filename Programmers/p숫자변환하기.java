import java.util.*;

class Node{
    int num;
    int depth;
    public Node(int num,int depth){
        this.num = num;
        this.depth = depth;
    }
}
class p숫자변환하기 {
    public int solution(int x, int y, int n) {
        int answer = 0;
        boolean isValid = false;
        Queue<Node> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[1000001];
        q.add(new Node(x,0));
        isVisited[x]=true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.num==y){
                isValid=true;
                answer = node.depth;
                break;
            }
            if(node.num+n<=y && !isVisited[node.num+n]){
                q.add(new Node(node.num+n,node.depth+1));
                isVisited[node.num+n]=true;
            }
            if(node.num*2<=y && !isVisited[node.num*2]){
                q.add(new Node(node.num*2,node.depth+1));
                isVisited[node.num*2]=true;
            }
            if(node.num*3<=y && !isVisited[node.num*3]){
                q.add(new Node(node.num*3,node.depth+1));
                isVisited[node.num*3]=true;
            }

        }
        return isValid?answer:-1;
    }
}