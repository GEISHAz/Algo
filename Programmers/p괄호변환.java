package Programmers;

import java.util.*;

class p괄호변환 {

    public String solution(String p) {
        if (check(p)) return p;
        return change(p);
    }

    // s가 올바른 문자열인지 판단하는 메서드
    public boolean check(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') st.add(c);
            else {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }

        return st.isEmpty();
    }

    // P에 대하여 U 와 V로 나누는 method
    public String change(String p) {
        // 더 이상 쪼갤 수 없는 경우 빈 문자열 반환
        if (p.length() == 0) return p;

        // 균형 잡힌 문자열로 나누기
        String u = "", v = "";
        int count = 0;
        boolean check = true;
        int idx = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                count++;
            else
                count--;

            if (count < 0) check = false;

            if (count == 0) {
                idx = i + 1; // 균형이 맞춰진 시점에서 index를 저장
                break;
            }
        }

        // U, V로 분리
        u = p.substring(0, idx);
        v = p.substring(idx);

        // 3. U가 올바른 문자열이라면, V에 대해 재귀적으로 해결한 뒤 U + V 반환
        if (check(u)) {
            return u + change(v);
        } else {
            // 4. U가 올바른 문자열이 아니면 변환
            return valence(u, v);
        }
    }

    // U를 올바른 괄호 문자열로 바꾸는 method
    public String valence(String u, String v) {
        StringBuilder sb = new StringBuilder();

        // 4-1. 빈 문자열에서 시작하여 '(' 추가
        sb.append("(");

        // 4-2. V에 대해 재귀적으로 solution을 수행한 결과를 추가
        sb.append(change(v));

        // 4-3. ')' 추가
        sb.append(")");

        // 4-4. U의 첫 번째와 마지막 문자를 제거하고, 괄호 방향을 반대로 변환
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }
}
