class p쿼드압축후갯수세기 {
    public int one = 0 , zero = 0;
    public int[] solution(int[][] arr) {
        ck(0,arr[0].length,0,arr[0].length,arr);
        int[] answer = {zero, one};
        return answer;
    }
    public void ck(int sx, int ex, int sy, int ey , int[][] arr){
        int num = arr[sx][sy];
        if(ex-sx != 1 && ey-sy !=1){
            for(int i = sx ; i < ex ; i++){
                for(int j = sy ; j < ey ; j++){
                    if(num != arr[i][j]){
                        ck(sx,(sx+ex)/2,sy,(sy+ey)/2,arr);
                        ck(sx,(sx+ex)/2,(sy+ey)/2,ey,arr);
                        ck((sx+ex)/2,ex,sy,(sy+ey)/2,arr);
                        ck((sx+ex)/2,ex,(sy+ey)/2,ey,arr);
                        return ;
                    }
                }
            }
        }
        if(num == 0) zero++;
        else one++;
        return ;
    }
}