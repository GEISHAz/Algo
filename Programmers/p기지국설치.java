package Programmers;

import java.util.ArrayList;
import java.util.List;

// 단위가 ㅈㄴ큼 아파트가 2억채 일수 있다.
// 그래서 최적화가 중요한데
// 일단 범위가 얼마나 커버할 수 있나.가 중요할듯
// 나누기와 퍼센트 활용
// 이미 설치된 station 기준으로 넘어가자.
//
class p기지국설치 {
    public int solution(int n, int[] st, int w) {
        int ans = 0;
        int wide = 2 * w + 1; // 한 기지국 커버 범위
        int end = 0; // 이전 기지국 커버 끝 지점

        for (int s : st) {
            int start = s - w; // 현재 기지국 커버 시작 지점
            if (start > end + 1) { // 커버되지 않은 구간 존재 시
                int gaps = start - (end + 1);
                ans += (gaps + wide - 1) / wide; // 필요한 기지국 수
            }
            end = s + w; // 현재 기지국 커버 끝 지점
        }

        // 마지막 기지국 이후 남은 아파트 커버
        if (end < n) {
            int remain = n - end;
            ans += (remain + wide - 1) / wide; // 남은 구간 기지국 수
        }

        return ans;
    }
}

