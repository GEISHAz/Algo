package Programmers;
import java.util.*;

class p충돌위험찾기 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || o.getClass() != getClass()) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    HashMap<Point, Integer> map = new HashMap<>();
    List<Point[]> pointSec = new ArrayList<>();
    int robotNum, maxSec = Integer.MIN_VALUE;

    // 충돌 횟수 계산
    private int count() {
        int answer = 0;
        for (int t = 0; t < maxSec; t++) {
            map.clear();
            for (int i = 0; i < robotNum; i++) {
                Point[] p = pointSec.get(i);
                if (t >= p.length) continue;
                Point pt = p[t];
                int c = map.getOrDefault(pt, 0);
                if (c == 1) answer++;
                map.put(pt, c + 1);
            }
        }
        return answer;
    }

    private Point[] getPointPerSec(int n, int[][] routes, int[][] points) {
        List<Point> list = new ArrayList<>();
        int nx = points[routes[n][0] - 1][0];
        int ny = points[routes[n][0] - 1][1];
        list.add(new Point(nx, ny));

        for (int i = 1; i < routes[n].length; i++) {
            int toX = points[routes[n][i] - 1][0];
            int toY = points[routes[n][i] - 1][1];
            while (nx != toX || ny != toY) {
                if (nx != toX) {
                    nx += (toX > nx) ? 1 : -1;
                } else {
                    ny += (toY > ny) ? 1 : -1;
                }
                list.add(new Point(nx, ny));
            }
        }
        maxSec = Math.max(maxSec, list.size());
        return list.toArray(new Point[0]);
    }

    public int solution(int[][] points, int[][] routes) {
        robotNum = routes.length;
        for (int i = 0; i < robotNum; i++) {
            Point[] arr = getPointPerSec(i, routes, points);
            pointSec.add(arr);
        }
        return count();
    }
}
