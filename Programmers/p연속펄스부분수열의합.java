package Programmers;

class p연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        // 2가지 배열로 나눌것 -1, 1 로 시작하는배열로
        int a = 1, b = -1, size = sequence.length;
        long aSum = sequence[0], bSum = sequence[0] * -1, aMin = 0, bMin = 0, max = Long.MIN_VALUE;

        for (int i = 1; i <= size; i++) {
            a *= -1;
            b *= -1;

            max = Math.max(max, aSum - aMin);
            max = Math.max(max, bSum - bMin);

            aMin = Math.min(aMin, aSum);
            bMin = Math.min(bMin, bSum);

            if (i == size) break;

            aSum += sequence[i] * a;
            bSum += sequence[i] * b;
        }
        return max;
    }
}
