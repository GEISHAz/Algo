package Programmers;

//[x,y,a,b] a = 종류 0 기둥 1 보 0 / b = 설치,삭제 1 설치 20 삭제

class p_Pillars_And_Beams {

    boolean[][] pillars;
    boolean[][] beams;
    int count = 0;

    public int[][] solution(int n, int[][] build_frame) {
        pillars = new boolean[n + 1][n + 1];
        beams = new boolean[n + 1][n + 1];

        for (int[] order : build_frame) {
            int x = order[0];
            int y = order[1];
            int type = order[2];
            int action = order[3];

            if (type == 0) { // 기둥
                if (action == 1) {
                    if (isVaildPillar(x, y)) {
                        pillars[x][y] = true;
                        count++;
                    }
                } else {
                    pillars[x][y] = false;
                    if (!canDelete(n)) pillars[x][y] = true;
                    else count--;
                }
            } else { // 보
                if (action == 1) {
                    if (isVaildBeam(x, y)) {
                        beams[x][y] = true;
                        count++;
                    }
                } else {
                    beams[x][y] = false;
                    if (!canDelete(n)) beams[x][y] = true;
                    else count--;
                }
            }
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if (beams[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }

    public boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (beams[i][j] && !isVaildBeam(i, j)) return false;
                if (pillars[i][j] && !isVaildPillar(i, j)) return false;
            }
        }
        return true;
    }

    // 기둥 유효성 검증
    public boolean isVaildPillar(int x, int y) {
        if (y == 0) return true;
        else if (y > 0 && pillars[x][y - 1]) return true;
        else if (x > 0 && beams[x - 1][y] || beams[x][y]) return true;
        return false;
    }

    // 보 유효성 검증
    public boolean isVaildBeam(int x, int y) {
        if (y > 0 && pillars[x][y - 1] || pillars[x + 1][y - 1]) return true;
        else if (x > 0 && beams[x - 1][y] && beams[x + 1][y]) return true;
        return false;
    }
}


