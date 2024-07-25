import java.util.*;

class Move{
    int startx,starty;
    int endx,endy;
    public Move(int a, int b, int c, int d){
        startx = a;
        starty = b;
        endx = c;
        endy = d;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return startx == move.startx && starty == move.starty
                && endx == move.endx && endy == move.endy;
    }
    @Override
    public int hashCode(){
        return Objects.hash(startx,starty,endx,endy);
    }
}
class p방문길이 {
    public int solution(String dirs) {
        int x=0, y=0, xx, yy;
        HashSet<Move> moves = new HashSet<>();
        for(int i = 0 ; i < dirs.length() ; i++){
            char dir = dirs.charAt(i);
            if(dir == 'U'){ yy = y+1; xx = x;}
            else if(dir == 'D'){ yy = y-1; xx = x;}
            else if(dir == 'R'){ xx = x+1; yy = y;}
            else{ xx = x-1; yy = y;}

            if (xx >= -5 && xx <= 5 && yy >= -5 && yy <= 5) {
                moves.add(new Move(x,y,xx,yy));
                moves.add(new Move(xx,yy,x,y));
                x = xx;
                y = yy;
            }
        }
        return moves.size()/2;
    }
}