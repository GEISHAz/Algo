package Programmers;

// String,boolean 을 받는 Map 을 통해 체크가능
// BFS 사용 가능
// 시작 단어 start 를 queue에 삽입
// 시작단어가 end 단어라면 find true 하고 break
// Queue에서 꺼내서 words 가 check 맵을 확인했을때 미방문이고 1개만 다르다면 q에삽입
// 1개 이상 다르다면 pass
//
import java.util.*;

class p단어변환 {
    class Node{
        String word;
        int n;
        public Node(String word,int n){
            this.word = word;
            this.n = n;
        }
    }
    private HashMap<String,Boolean> isVisited = new HashMap<>();
    private boolean comparsion(String s, String c,int length){
        int check = 1;
        for(int i = 0; i < length; i++)
            if(s.charAt(i) != c.charAt(i)) check--;
        return check < 0 ? false : true;
    }
    private int bfs(String[] words,String begin, String target){
        int answer = 0, length = begin.length();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(target.equals(now.word)){ //찾았으면
                answer = now.n;
                break;
            }
            for(String word : words){
                if(!isVisited.getOrDefault(word,false)
                        && comparsion(now.word,word,length)){ // 1개만 다르면
                    q.add(new Node(word,now.n+1)); //q에 넣기
                    isVisited.put(word,true); // 방문체크
                }
            }
        }
        return answer;
    }
    public int solution(String begin, String target, String[] words) {
        return bfs(words,begin,target);
    }
}