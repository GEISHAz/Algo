package Programmers;

import java.util.*;

class p수식최대화 {
    public long solution(String expression) {
        long answer = 0;

        // 포함된 연산자를 추출하여 문자열로 만듦
        StringBuilder str = new StringBuilder();
        if(expression.contains("+")) str.append("+");
        if(expression.contains("-")) str.append("-");
        if(expression.contains("*")) str.append("*");

        // 연산자의 모든 우선순위 조합을 계산
        String[] combi = combination(str.toString());

        // 각 조합마다 계산을 수행하고 최대값을 찾음
        for(String st : combi){
            long ans = Math.abs(calculate(expression, st));
            if(answer < ans)
                answer = ans;
        }

        return answer;
    }

    // 순열을 반환하는 메서드
    public String[] combination(String s){
        ArrayList<String> arr = new ArrayList<>();
        permute(s,"",arr);
        return arr.toArray(new String[0]);
    }

    // 순열을 생성하는 메서드
    private static void permute(String str, String prefix, List<String> result) {
        int n = str.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(str.substring(0, i) + str.substring(i + 1, n), prefix + str.charAt(i), result);
            }
        }
    }

    // 수식을 계산하는 메서드
    public static long calculate(String expression, String operators) {
        // 숫자와 연산자를 분리
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        int i = 0;
        StringBuilder number = new StringBuilder();

        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                numbers.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                ops.add(c);
            }
            i++;
        }
        numbers.add(Long.parseLong(number.toString())); // 마지막 숫자 추가

        // 연산자 우선순위에 따라 계산
        for (char operator : operators.toCharArray()) {
            int j = 0;
            while (j < ops.size()) {
                if (ops.get(j) == operator) {
                    // 두 숫자를 해당 연산자로 계산
                    long result = performOperation(numbers.remove(j), numbers.remove(j), operator);
                    numbers.add(j, result);  // 결과를 숫자 리스트에 다시 추가
                    ops.remove(j);  // 연산자를 제거
                } else {
                    j++;
                }
            }
        }

        // 최종 계산 결과 반환
        return numbers.get(0);
    }

    // 실제 연산을 수행하는 메서드
    private static long performOperation(long a, long b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
