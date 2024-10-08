import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println((a+b-c));
        System.out.println((Integer.parseInt(String.valueOf(a)+String.valueOf(b))-c));
    }
}
