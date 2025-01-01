package Programmers;

class p이모티콘할인행사 {
    int[] answer = {0,0};
    public void combination(int[] arr, int count, int[][] users, int[] emoticons){
        if(count == emoticons.length){
            check(arr,users,emoticons);
            return ;
        }
        for(int i = 10; i <= 40; i+=10){
            arr[count] = i;
            combination(arr,count+1,users,emoticons);
        }
    }
    public void check(int[] arr, int[][] users, int[] emoticons){
        int plus = 0;
        int money = 0;
        for(int i = 0 ; i < users.length ; i++){
            int mem = 0;
            for(int j = 0 ; j < emoticons.length; j++){
                if(users[i][0]<=arr[j]){
                    mem += (emoticons[j]/100) * (100-arr[j]);
                }
            }
            if(users[i][1] <= mem){
                plus++;
            }else{
                money += mem;
            }
        }
        if(answer[0] < plus || (answer[0] == plus && answer[1] < money)){
            answer[0] = plus;
            answer[1] = money;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];
        // 조합짜기
        combination(arr,0,users,emoticons);
        // 짠조합 체크 및 결과저장
        return answer;
    }
}