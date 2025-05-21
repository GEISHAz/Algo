import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b9358 {
    
    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    static int TC, answer;
    static char[][] map;
    static boolean[][] isVisited;
    static Queue<Node> q;
    static HashMap<Character, ArrayList<Node>> savedDoor;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++){
            logic(br);
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static void logic(BufferedReader br) throws IOException{
        StringTokenizer st= new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        map = new char[height][width];
        for(int i = 0 ; i < height ; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[] hasKey = new boolean[26];
        String keyInfo = br.readLine();
        if(!keyInfo.equals("0")){
            char[] keys = keyInfo.toCharArray();
            for(int i = 0 ; i < keys.length ; i++)
                hasKey[keys[i]-'a'] = true;
        }
        // Input end. BFS start
        BFS(height, width, hasKey);

    }

    private static void BFS(int height, int width, boolean[] hasKey) {
        answer = 0;
        q = new ArrayDeque<>();
        isVisited = new boolean[height][width];
        savedDoor = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++){
            savedDoor.put((char)('a'+i),new ArrayList<>());
        }
        for(int i = 0; i < width; i++){
            check(0,i, hasKey,0);
            check(height-1,i,hasKey,0);
        }
        for(int i = 0; i < height; i++){
            check(i,0, hasKey,0);
            check(i,width-1,hasKey,0);
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int dir = 0 ; dir < 4 ; dir++){
                int dx = cur.x+d[dir][0];
                int dy = cur.y+d[dir][1];
                if(dx < 0 || dy < 0 || dx >= height || dy >= width || isVisited[dx][dy]) continue;
                check(dx,dy, hasKey,1);
            }
        }
    }

    public static void check(int x, int y, boolean[] hasKey, int version){
        if(map[x][y] != '*' && !isVisited[x][y]){
            if(map[x][y] == '$'){
                map[x][y] = '.';
                answer++;
                isVisited[x][y] = true;
            }
            else if(map[x][y] == '.'){
                isVisited[x][y] = true;
            }
            else if(map[x][y] >= 'a' && map[x][y] <= 'z'){
                hasKey[map[x][y]-'a'] = true;
                isVisited[x][y] = true;

                if(version == 1) {
                    ArrayList<Node> tmp = savedDoor.get(map[x][y]);
                    for (Node cur : tmp) {
                        q.add(cur);
                        isVisited[cur.x][cur.y] = true;
                    }
                    savedDoor.get(map[x][y]).clear();
                }
            }
            else if(map[x][y] >= 'A' && map[x][y] <= 'Z'){
                if(hasKey[map[x][y]-'A']) {
                    map[x][y] = '.';
                    isVisited[x][y] = true;
                }
                else {
                    savedDoor.get(Character.toLowerCase(map[x][y])).add(new Node(x,y));
                    return ;
                }
            }
            q.add(new Node(x, y));
        }

    }
}


