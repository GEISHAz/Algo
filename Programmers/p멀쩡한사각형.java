package Programmers;

class p멀쩡한사각형 {
    public long solution(int w, int h) {
        long ref = gcd(w, h);
        return ((long) w * h) - (((w / ref) + (h / ref) - 1) * ref);
    }

    public int gcd(int w, int h) {
        if (h == 0) return w;
        return gcd(h, w % h);
    }
}