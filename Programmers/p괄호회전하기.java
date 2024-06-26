import java.util.*;

class p괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i++)
            q.offer(s.charAt(i));

        for(int i = 0 ; i < s.length(); i++){
            if(isValid(q))
                answer++;
            q.offer(q.poll());
        }
        return answer;
    }
    public boolean isValid(Queue<Character> q){
        Stack<Character> st = new Stack<>();
        for(Character c : q){
            if(c == '(' || c == '{' || c == '[')
                st.add(c);
            else{
                if(st.isEmpty())
                    return false;
                Character top = st.pop();
                if((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
