class p땅따먹기 {
    int maxScore(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
    int solution(int[][] land) {
        int answer = 0,last;
        for(int i = 1 ; i < land.length ; i++){
            land[i][0]+=maxScore(land[i-1][1],land[i-1][2],land[i-1][3]);
            land[i][1]+=maxScore(land[i-1][0],land[i-1][2],land[i-1][3]);
            land[i][2]+=maxScore(land[i-1][1],land[i-1][0],land[i-1][3]);
            land[i][3]+=maxScore(land[i-1][1],land[i-1][2],land[i-1][0]);
        }
        return Math
                .max(land[land.length-1][3],
                        maxScore(land[land.length-1][0],land[land.length-1][1],land[land.length-1][2]));
    }
}