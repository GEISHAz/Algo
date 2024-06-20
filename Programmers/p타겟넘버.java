class p타겟넘버 {
    public int answer = 0, end;
    public boolean[] isVisited;
    public int solution(int[] numbers, int target) {
        isVisited = new boolean[numbers.length];
        end = target;
        DFS(0,numbers,0);
        return answer;
    }
    public void DFS(int depth, int[] numbers, int num){
        if(depth == numbers.length){
            if(end == num)
                answer++;
            return;
        }
        isVisited[depth]=true;
        DFS(depth+1,numbers,num+numbers[depth]);
        DFS(depth+1,numbers,num-numbers[depth]);
        isVisited[depth]=false;
    }
}