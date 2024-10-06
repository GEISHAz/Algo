package Programmers;
// 시간계산
// musicinfo 를 돌아가면서 끝시간 - 시작시간으로 문자열길이 확정
// 배열길이만큼 musicinfo 의 악보를 차례대로 집어넣음 끊기면 어쩔수없
// 거기서 m이라는 기억한 멜로디가 존재하는지 확인하되 끝부분이 #이면 안된다. ㅇㅋ?
// String.contains로 만들면되겠네그리고 만약 Contains 가 같으면 X
// 배열말고 문자열로 해도되겠다.
// Map에 저장하자 String,String 으로 제목, 노래 길이 문자열 음
// 치환 해보자 C#을 c로 ㅇㅇ 이런식
import java.util.*;

class p방금그곡 {
    class Music {
        String name;
        String melody;
        int playTime; // 재생 시간을 저장하기 위한 변수 추가

        public Music(String name, String melody, int playTime) {
            this.name = name;
            this.melody = melody;
            this.playTime = playTime; // 재생 시간을 저장
        }
    }

    private String substitution(String str) {
        // 치환 함수, 음표를 간소화하여 비교하기 쉽도록 함
        String s = str.replace("A#", "a");
        s = s.replace("C#", "c");
        s = s.replace("D#", "d");
        s = s.replace("F#", "f");
        s = s.replace("G#", "g");
        return s;
    }

    private int changeInt(String hour) {
        // 문자열로 주어진 시간을 분 단위로 변환
        int result = Integer.parseInt(hour.substring(0, 2)) * 60;
        result += Integer.parseInt(hour.substring(3, 5));
        return result;
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<Music> list = new ArrayList<>();
        m = substitution(m); // 기억한 멜로디도 치환

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int playTime = changeInt(parts[1]) - changeInt(parts[0]);
            String musicTitle = parts[2];
            String sheetMusic = substitution(parts[3]);

            StringBuilder melody = new StringBuilder();
            while (melody.length() < playTime) {
                melody.append(sheetMusic);
            }
            melody.setLength(playTime); // 재생 시간만큼만 멜로디 설정

            list.add(new Music(musicTitle, melody.toString(), playTime)); // 음악 정보 추가
        }

        // 재생 시간이 긴 음악부터 검사하고, 그 중에서 가장 먼저 나온 곡을 선택
        Collections.sort(list, (m1, m2) -> m2.playTime - m1.playTime);

        for (Music music : list) {
            if (music.melody.contains(m)) { // 조건에 맞는 멜로디가 있는지 확인
                answer = music.name;
                break;
            }
        }
        return answer;
    }
}
