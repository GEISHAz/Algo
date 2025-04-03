package Programmers;

class p_Advertisement_insertion {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playLength = toSeconds(play_time);
        int advLength = toSeconds(adv_time);

        long[] viewers = new long[playLength + 2];

        for (String log : logs) {
            int start = toSeconds(log.substring(0, 8));
            int end = toSeconds(log.substring(9, 17));
            viewers[start] += 1;
            viewers[end] -= 1;
        }

        for (int i = 1; i <= playLength; i++) {
            viewers[i] += viewers[i - 1];
        }

        for (int i = 1; i <= playLength; i++) {
            viewers[i] += viewers[i - 1];
        }

        long maxViewTime = viewers[advLength - 1];
        int answerTime = 0;

        for (int i = advLength; i <= playLength; i++) {
            long viewTime = viewers[i] - viewers[i - advLength];
            if (viewTime > maxViewTime) {
                maxViewTime = viewTime;
                answerTime = i - advLength + 1;
            }
        }

        return toTime(answerTime);
    }

    private int toSeconds(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        int s = Integer.parseInt(time.substring(6, 8));
        return h * 3600 + m * 60 + s;
    }

    private String toTime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}