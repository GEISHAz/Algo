package Programmers;
import java.util.*;

class pPlayTicTacToeAlone {
    char[][] map = new char[3][3];
    boolean bingoO = false, bingoX = false;

    void isBingo(int n) {
        char target = map[n][n];
        if (target == '.') return;
        if ((map[n][0] == target && map[n][1] == target && map[n][2] == target) ||
                (map[0][n] == target && map[1][n] == target && map[2][n] == target)) {
            if (target == 'O') bingoO = true;
            else if (target == 'X') bingoX = true;
        }
    }

    void crossLineCheck() {
        if ((map[0][0] == map[1][1] && map[1][1] == map[2][2]) ||
                (map[2][0] == map[1][1] && map[1][1] == map[0][2])) {
            if (map[1][1] == 'O') bingoO = true;
            else if (map[1][1] == 'X') bingoX = true;
        }
    }

    boolean isValidRule(int oCount, int xCount) {
        for (int i = 0; i < 3; i++) {
            isBingo(i);
        }
        crossLineCheck();

        if (bingoO && bingoX) return false;
        if (bingoO && oCount != xCount + 1) return false;
        if (bingoX && oCount != xCount) return false;

        return true;
    }

    boolean checkCount(int oCount, int xCount) {
        return oCount == xCount || oCount == xCount + 1;
    }

    public int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') oCount++;
                else if (map[i][j] == 'X') xCount++;
            }
        }

        if (!checkCount(oCount, xCount)) return 0;

        return isValidRule(oCount, xCount) ? 1 : 0;
    }
}
