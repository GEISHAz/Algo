import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean isTag = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                result.append(word.reverse());
                word.setLength(0);
                isTag = true;
                result.append(c);
            } else if (c == '>') {
                isTag = false;
                result.append(c);
            } else if (isTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    result.append(word.reverse());
                    result.append(' ');
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }
        result.append(word.reverse());

        System.out.println(result);
    }
}