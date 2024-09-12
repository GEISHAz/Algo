package Programmers;

// x와 y축으로 1자로 쫙 그리는건 쉽다.
// 중요한건 1자로 그린 후 최대값 최솟값을 정해서 싹다 거리재고 d랑비교 해야한다는거

// x축으로 쭉가면서 찍은점들 거리 disList 확보
// disList * 2 - 1 이 x,y축 점들 갯수
// 즉 answer.
// disList 정렬
// disList에서 하나씩 빼가면서 싹다
// 거리비교하고 되면 answer++;
// 안되면 continue;



// import java.util.*;

// class Solution {
//     List <Integer> disList = new ArrayList<>();
//     long answer = 0;
//     private void findCorrectCombination(int d){
//         Collections.sort(disList);
//         for(int n : disList){
//             for(int a: disList){
//                 if(Math.pow(n,2)+Math.pow(a,2)>Math.pow(d,2)) //거리넘으면
//                     break;
//                 answer++;
//             }
//         }
//     }
//     public long solution(int k, int d) {
//         for(int i = 1 ; i * k <= d ; i++)
//             disList.add(i*k);
//         answer = disList.size()*2 + 1;
//         findCorrectCombination(d);
//         return answer;
//     }
// }

// 시간복잡도 O*O 로 인한
// 시간초과 발생
// 보다 수학적인 접근
import java.util.*;

class p점찍기 {
    private long calculate(int x, int k, int d) {
        long xDist = x * (long)k;
        return (long)Math.sqrt((long)d * d - xDist * xDist) / k;
    }

    private long countPossible(int k, int d) {
        long count = 0;
        for (int x = 0; x * k <= d; x++)
            count += calculate(x, k, d) + 1; // 0 포함
        return count;
    }

    public long solution(int k, int d) {
        return countPossible(k, d);
    }
}
