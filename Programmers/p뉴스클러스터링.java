import java.util.*;

class p뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0, n = 0, u = 0;
        ArrayList<String> list1 = makeList(str1.toLowerCase());
        ArrayList<String> list2 = makeList(str2.toLowerCase());
        ArrayList<String> intersection = new ArrayList<>();
        for (String s : list1) {
            if (list2.contains(s)) {
                intersection.add(s);
                list2.remove(s);
            }
        }
        n = intersection.size();
        u = list1.size() + list2.size();

        if (u == 0)
            answer = 65536;
        else
            answer = (int) ((double) n / (double) u * 65536);

        return answer;
    }

    public ArrayList<String> makeList(String str) {
        ArrayList<String> list = new ArrayList<>();
        String s;
        for (int i = 0; i < str.length() - 1; i++) {
            if ('a' <= str.charAt(i) && 'z' >= str.charAt(i)
                    && 'a' <= str.charAt(i + 1) && 'z' >= str.charAt(i + 1)) {
                s = str.substring(i, i + 2);
                list.add(s);
            }
        }
        return list;
    }
}