package Programmers;

import java.util.*;

class p인사고과 {
    class Person {
        int scoreSum;
        int scoreA;
        int scoreB;
        int num;
        int rank;

        public Person(int scoreA, int scoreB, int num) {
            this.scoreSum = scoreA + scoreB;
            this.scoreA = scoreA;
            this.scoreB = scoreB;
            this.num = num;
        }

        public void setRank(int n) {
            this.rank = n;
        }
    }

    public int solution(int[][] scores) {
        int answer = 0;
        int size = scores.length;
        int n = scores[0][0];
        int m = scores[0][1];

        Person[] arr = new Person[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Person(scores[i][0], scores[i][1], i);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.scoreA != o2.scoreA) return o2.scoreA - o1.scoreA;
            return o1.scoreB - o2.scoreB;
        });

        int maxScoreB = 0;
        for (Person person : arr) {
            if (person.scoreB < maxScoreB) {
                if (person.scoreA == n && person.scoreB == m)
                    return -1;
                person.scoreA = -1;
                person.scoreB = -1;
            } else {
                maxScoreB = person.scoreB;
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            return (o2.scoreSum) - (o1.scoreSum);
        });

        answer = 1;
        for (Person person : arr) {
            if (person.scoreA == -1 && person.scoreB == -1) continue; // 제외된 사람 건너뛰기
            if (person.scoreSum > n + m) {
                answer++;
            } else if (person.scoreA == n && person.scoreB == m) {
                break;
            }
        }

        return answer;
    }
}
