package Programmers;

import java.util.Arrays;

class p가장긴펠린드롬 {
    private int answer = 0;

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int solution(String s) {
        int arrSize = s.length();

        for (int i = arrSize; i > 0; i--) {
            for (int j = 0; j + i <= arrSize; j++) {
                int end = j + i - 1;
                if (isPalindrome(s, j, end)) {
                    return i;
                }
            }
        }
        return 0;
    }
}