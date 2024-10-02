package Programmers;

// 장르별 두곡 모아 베스트 앨범 출시
// class genre {
// class music 사용
import java.util.*;

class p베스트앨범 {
    class Genre {
        int totPlays = 0;
        PriorityQueue<Music> pq = new PriorityQueue<>((m1, m2) -> {
            if (m1.plays == m2.plays)
                return m1.id - m2.id;
            return m2.plays - m1.plays;
        });
        public void add(Music m) {
            pq.add(m);
            totPlays += m.plays;
        }
    }
    class Music {
        int id;
        int plays;
        public Music(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new Genre());
            map.get(genres[i]).add(new Music(i, plays[i]));
        }
        List<Genre> sorted = new ArrayList<>(map.values());
        sorted.sort((g1, g2) -> g2.totPlays - g1.totPlays);
        List<Integer> ans = new ArrayList<>();
        for (Genre g : sorted) {
            int cnt = 0;
            while (!g.pq.isEmpty() && cnt < 2) {
                ans.add(g.pq.poll().id);
                cnt++;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
