package Programmers;
//제일 앞에서 정해진 부분만큼만 잘라야 한다.라는 부분
//결론은 1 개 2개 4개 이런식으로 자를수 없으며
//무조건 111,222,33333,4444 이런식으로 잘라야한다.
//subString을 이용하면 괜찮을거 같고
//만약 홀수면 많이 문제가 어려워지겠네

//단서
//홀수면 애매해진다. 나눌수 있는 숫자로만 가능하다.
//21이면 아무래도 1개 3개 7개 21개 로만 나눌수 있다.
//22면 1 2 11
//약수갯수만큼만 자를 수 있다라는점
//약수구하기 method 필요
//약수만큼 압축method 필요 (min 최신화 필요)
//subString

// import java.util.*;

// class Solution {
//     public int solution(String s) {
//         int size = s.length();
//         int[] numbers = findMeasure(size);
//         HashMap<String,Integer> map;
//         int idx = 0, min = Integer.MAX_VALUE;

//         for(int num : numbers){
//             System.out.println("======num is "+num);
//             idx = 0;
//             map = new HashMap<>();
//             while(idx<size){
//                 String str = s.substring(idx,idx+num);
//                 if(map.containsKey(str))
//                     map.put(str,map.get(str)+1);
//                 else
//                     map.put(str,1);
//                 idx+=num;
//             }
//             int afterSize = 0;

//             System.out.println("mapSize = " + map.size());

//             for(int howMuch : map.values()){
//                 System.out.print(" value= "+howMuch);
//                 if(howMuch != 1)
//                     afterSize += String.valueOf(howMuch).length();
//                 afterSize += num;
//             }
//             min = min < afterSize ? min : afterSize; //최신화

//         }
//         return min;
//     }
//     private int[] findMeasure(int size){
//         List<Integer> arr = new ArrayList<>();
//         for(int i = 1 ; i < (size / 2) + 1 ; i++)
//             if(size%i==0)
//                 arr.add(i);
//         for(int n : arr){
//             System.out.print(n+" ");
//         }
//         System.out.println();

//         return arr.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
import java.util.*;

class p문자열압축 {
	public int solution(String s) {
		int size = s.length();
		if (size == 1) return 1;  // 문자열 길이가 1인 경우 예외 처리

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= size / 2; i++) {
			int idx = 0;
			String save = s.substring(0, i);
			StringBuilder sb = new StringBuilder();
			int count = 1;
			idx += i;

			while (idx < size) {
				String str;
				if (idx + i > size)
					str = s.substring(idx, size);
				else
					str = s.substring(idx, idx + i);

				if (save.equals(str)) {
					count++;
				} else {
					if (count > 1) sb.append(count);
					sb.append(save);
					save = str;
					count = 1;
				}
				idx += i;
			}

			// 마지막 남은 부분 처리
			if (count > 1) sb.append(count);
			sb.append(save);

			int compressedLength = sb.toString().length();
			min = Math.min(min, compressedLength);
		}

		return min;
	}
}
