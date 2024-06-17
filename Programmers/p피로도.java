class p피로도 {

    public int answer=0;
    public boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        DFS(0,k,dungeons);
        return answer;
    }
    public void DFS(int depth,int k,int[][] dungeons){
        for(int i = 0 ; i < dungeons.length ; i++){
            if(!isVisited[i] && k-dungeons[i][0]>=0){
                isVisited[i]=true;
                DFS(depth+1,k-dungeons[i][1],dungeons);
                isVisited[i]=false;
            }
        }
        answer = Math.max(answer,depth);
    }
}