import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class b30804 {
    // start 지점 당기기
    private static int answer = Integer.MIN_VALUE, start = 0;;
    private static HashMap<String,Integer> map = new HashMap<>();
    private static void removeStart(String[] input){
        if(map.get(input[start]) == 1)
            map.remove(input[start]);
        else
            map.put(input[start], map.get(input[start]) - 1);
        start++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        //선언
        for(int i = 0 ; i < N ; i++) {
            //end 올리기 1회
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
            if(map.size() <= 2) answer = Math.max(i-start+1,answer);
            while(map.size() > 2){
                removeStart(input);
            }
        }
        System.out.println(answer);
    }
}
