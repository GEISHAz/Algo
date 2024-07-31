import java.util.*;

class p삼각달팽이 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] map = new int[n][n];
        int x = -1, y = 0, c = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n - i ; j++){
                if(i%3==0)
                    x+=1;
                else if(i%3==1)
                    y+=1;
                else{
                    x-=1;
                    y-=1;
                }
                map[x][y]=c;
                c++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j]!=0)
                    answer.add(map[i][j]);
                else
                    break;
            }
        }
        return answer;
    }
}