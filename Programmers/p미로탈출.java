import java.util.*;

class p미로탈출{
    static String[][] MIRO;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    public int solution(String[] maps) {
        MIRO = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        // 미로 배열 초기화 및 출발점(S), 레버(L), 출구(E) 위치 저장
        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");
            for (int j = 0; j < tmp.length; j++) {
                MIRO[i][j] = tmp[j];
                if (MIRO[i][j].equals("S")) {
                    start = new int[]{i, j};
                } else if (MIRO[i][j].equals("L")) {
                    lever = new int[]{i, j};
                } else if (MIRO[i][j].equals("E")) {
                    end = new int[]{i, j};
                }
            }
        }

        // 출발점에서 레버까지의 최단 경로
        int toLever = bfs(start, "L");
        // 레버에서 출구까지의 최단 경로
        int toEnd = bfs(lever, "E");

        // 경로가 존재하지 않을 경우 -1 반환
        if (toLever == -1 || toEnd == -1) {
            return -1;
        }

        // 최종 경로 반환
        return toLever + toEnd;
    }

    // BFS를 이용한 최단 경로 탐색 함수
    public int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[MIRO.length][MIRO[0].length];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            // 목표 지점에 도달하면 경로 길이 반환
            if (MIRO[x][y].equals(target)) {
                return count;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 경계 내에서, 방문하지 않았고 벽이 아닌 경우 탐색
                if (nx >= 0 && ny >= 0 && nx < MIRO.length && ny < MIRO[0].length
                        && !visited[nx][ny] && !MIRO[nx][ny].equals("X")) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
