import java.io.IOException;
import java.util.Scanner;

public class b1002 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int dx = x1 - x2;
            int dy = y1 - y2;
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance == 0 && r1 == r2) {
                System.out.println(-1); // 같은 원
            } else if (distance > r1 + r2) {
                System.out.println(0); // 서로 멀리 떨어짐
            } else if (distance < Math.abs(r1 - r2)) {
                System.out.println(0); // 한 원이 다른 원 안에 있음
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                System.out.println(1); // 외접 또는 내접
            } else {
                System.out.println(2); // 두 점에서 만남
            }
        }
    }
}