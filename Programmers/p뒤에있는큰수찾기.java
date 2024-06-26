import java.util.*;

class p뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] answer = new int[numbers.length];
        for(int i = 1 ; i < numbers.length ; i++){
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.pop()]=-1;
        }
        return answer;
    }
}