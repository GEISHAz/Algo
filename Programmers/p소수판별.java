import java.util.*;

class p소수판별 {
    Set<Integer> isVisited;
    int answer;
    boolean[] numbersVisited;
    public void DFS(int n, int s, String numbers){
        if(n>=0 && !isVisited.contains(s)){
            if(check(s))
                answer++;
            isVisited.add(s);
        }
        for(int i = 0 ; i < numbers.length() ; i++)
            if(!numbersVisited[i])
            {
                numbersVisited[i]=true;
                DFS(n-1,(s*10)+numbers.charAt(i)-'0',numbers);
                numbersVisited[i]=false;
            }
    }
    public int solution(String numbers) {
        answer = 0;
        isVisited = new HashSet<>();
        numbersVisited = new boolean[numbers.length()];
        DFS(numbers.length(), 0 ,numbers);
        return answer;
    }
    public boolean check(int num){
        if (num < 2) {
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}