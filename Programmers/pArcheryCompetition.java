package Programmers;

public class pArcheryCompetition {
    int[] answer;
    int[] now;
    int maximum = 0;
    int score = 0;
    boolean found = false;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        now = new int[11];
        for (int i = 0; i < 10; i++) {
            if (info[i] != 0)
                score += (10 - i);
        }
        dfs(0, n, 0, score, info);
        if (!found)
            return new int[]{-1};
        return answer;
    }

    public void dfs(int depth, int count, int sum, int s, int[] info) {
        if (depth == 10) {
            now[10] = count;
            int diff = sum - s;
            if (diff > maximum) {
                maximum = diff;
                found = true;
                answer = now.clone();
            } else if (diff == maximum) {
                if (isBetter(now, answer))
                    answer = now.clone();
            }
            now[10] = 0;
            return;
        }

        if (count >= info[depth] + 1) {
            now[depth] = info[depth] + 1;
            if (info[depth] > 0)
                dfs(depth + 1, count - (info[depth] + 1), sum + (10 - depth), s - (10 - depth), info);
            else
                dfs(depth + 1, count - (info[depth] + 1), sum + (10 - depth), s, info);
            now[depth] = 0;
        }

        dfs(depth + 1, count, sum, s, info);
    }

    private boolean isBetter(int[] candidate, int[] current) {
        for (int i = 10; i >= 0; i--) {
            if (candidate[i] > current[i])
                return true;
            else if (candidate[i] < current[i])
                return false;
        }
        return false;
    }
}
