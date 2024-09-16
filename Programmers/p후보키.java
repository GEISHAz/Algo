package Programmers;

import java.util.*;

public class p후보키 {
    private List<Integer> candidateKeys = new ArrayList<>();
    private String[][] relation;
    private int columnLength;

    public int solution(String[][] relation) {
        this.relation = relation;
        this.columnLength = relation[0].length;
        for (int i = 1; i < (1 << columnLength); i++)
            if (isCandidateKey(i))
                candidateKeys.add(i);
        return candidateKeys.size();
    }
    private boolean isCandidateKey(int set) {
        if (!isUnique(set)) return false;
        for (Integer key : candidateKeys)
            if ((set & key) == key) return false;
        return true;
    }
    private boolean isUnique(int set) {
        Set<String> tuples = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder tuple = new StringBuilder();
            for (int j = 0; j < columnLength; j++) {
                if ((set & (1 << j)) != 0)
                    tuple.append(row[j]).append(",");
            }
            if (!tuples.add(tuple.toString())) return false;
        }
        return true;
    }
}