package Programmers;
class p프렌즈4블록 {
    boolean flag;
    boolean[][] check;
    int answer;
    public void blockCheck(char[][] table, int n, int m){
        for(int i = 0 ; i < m-1 ; i++){
            for(int j = 0 ; j < n-1 ; j++){
                if(table[i][j]=='-')
                    continue;
                char a = table[i][j];
                if(table[i][j+1]==a && table[i+1][j+1]==a && table[i+1][j]==a){
                    check[i][j] = true;
                    check[i][j+1] = true;
                    check[i+1][j] = true;
                    check[i+1][j+1] = true;
                    flag = false;
                }
            }
        }
    }
    public void blockDelete(char[][] table, int n, int m){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(check[i][j]){
                    table[i][j] = '-';
                    answer++;
                }
            }
        }
    }
    public void blockReset(char[][] table, int n, int m){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(table[i][j]=='-'){
                    for(int k=i;k<m;k++){
                        if(table[k][j]=='-'){
                            continue;
                        }
                        table[i][j]=table[k][j];
                        table[k][j]='-';
                        break;
                    }
                }
            }
        }
    }
    public int solution(int m, int n, String[] board) {
        answer = 0;
        char[][] table = new char[m][n];
        for(int i = 0 ; i < m ; i++){
            table[i]=board[m-i-1].toCharArray();
        }
        while(true){
            flag=true;
            check = new boolean[m][n];
            blockCheck(table,n,m);
            if(flag)
                break;
            blockDelete(table,n,m);
            blockReset(table,n,m);
        }
        return answer;
    }

}