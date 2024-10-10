import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b28702 {
    private static String isFizzBuzz(int n){
        if(n % 3 == 0 && n % 5 == 0)
            return "FizzBuzz";
        else if(n % 3 == 0)
            return "Fizz";
        else if(n % 5 == 0)
            return "Buzz";
        else
            return String.valueOf(n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = new String[3];
        int num=0, where=0;
        for(int i = 0 ; i < 3 ; i++){
            input[i] = br.readLine();
            if(!input[i].contains("z")){
                num = Integer.parseInt(input[i]);
                where = i;
            }
        }
        num += (3-where);

        System.out.println(isFizzBuzz(num));
    }
}
