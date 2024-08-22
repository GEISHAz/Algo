class p행렬테두리회전하기 {
    int[][] map;
    int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];
        set(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            answer[i] = turn(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }
    public void set(int rows, int columns) {
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
    }
    public int turn(int startX, int startY, int endX, int endY) {
        int min = Integer.MAX_VALUE;
        int temp = map[startX][startY];
        for (int i = startX; i < endX; i++) {
            map[i][startY] = map[i + 1][startY];
            min = Math.min(min, map[i][startY]);
        }
        for (int i = startY; i < endY; i++) {
            map[endX][i] = map[endX][i + 1];
            min = Math.min(min, map[endX][i]);
        }
        for (int i = endX; i > startX; i--) {
            map[i][endY] = map[i - 1][endY];
            min = Math.min(min, map[i][endY]);
        }
        for (int i = endY; i > startY; i--) {
            map[startX][i] = map[startX][i - 1];
            min = Math.min(min, map[startX][i]);
        }
        map[startX][startY + 1] = temp;
        min = Math.min(min, temp);
        return min;
    }
}
