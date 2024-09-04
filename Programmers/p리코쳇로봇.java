package Programmers;

import java.util.*;

class p리코쳇로봇 {
    // 전역 변수 선언
    boolean[][] isVisited;
    int[][] map;
    int xSize, ySize;

    // 좌표 클래스
    class Node {
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int solution(String[] board) {
        // 변수 선언
        int answer = -1;
        xSize = board[0].length();
        ySize = board.length;
        int[][] d = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<Node> q = new ArrayDeque<>();
        Node goal = null;

        isVisited = new boolean[ySize][xSize];
        map = new int[ySize][xSize];

        // map 초기화 및 시작점, 목표점 찾기
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'D') {
                    map[i][j] = 1; // 장애물을 1로 설정
                } else if (ch == 'R') {
                    q.add(new Node(j, i, 0)); // 로봇 시작 위치
                } else if (ch == 'G') {
                    goal = new Node(j, i, 0); // 목표 위치
                }
            }
        }

        // 시작점 또는 목표점이 없는 경우
        if (q.isEmpty() || goal == null) {
            return -1;
        }

        // BFS
        while (!q.isEmpty()) {
            Node now = q.poll();

            // 목표 지점 도달 시
            if (now.x == goal.x && now.y == goal.y) {
                answer = now.dis;
                break;
            }

            // 이미 방문한 경우 스킵
            if (isVisited[now.y][now.x]) continue;
            isVisited[now.y][now.x] = true;

            // 4방향 이동
            for (int i = 0; i < 4; i++) {
                Node after = move(d[i][0], d[i][1], now);
                if (after != null && !isVisited[after.y][after.x]) {
                    q.add(after);
                }
            }
        }

        return answer;
    }

    // 벽이나 장애물에 부딪힐 때까지 이동 후 좌표 반환
    public Node move(int dx, int dy, Node now) {
        int nowX = now.x;
        int nowY = now.y;

        while (true) {
            nowX += dx;
            nowY += dy;

            // 경계를 벗어나거나 장애물에 부딪힌 경우
            if (nowX < 0 || nowX >= xSize || nowY < 0 || nowY >= ySize || map[nowY][nowX] == 1) {
                nowX -= dx;
                nowY -= dy;
                break;
            }
        }

        // 최종 좌표가 방문한 곳이라면 null 반환
        if (isVisited[nowY][nowX]) return null;

        return new Node(nowX, nowY, now.dis + 1);
    }
}