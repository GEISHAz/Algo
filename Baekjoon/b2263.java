import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    public class b2263 {

        static int N;
        static int[] inOrder,postOrder,index;
        static StringBuilder sb;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            inOrder = new int[N+1];
            postOrder = new int[N+1];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i = 1 ; i <= N ; i++){
                inOrder[i] = Integer.parseInt(st1.nextToken());
                postOrder[i] = Integer.parseInt(st2.nextToken());
            }

            index = new int[N+1];
            for(int i = 1 ; i <= N ; i++){
                index[inOrder[i]] = i;
            }

            sb = new StringBuilder();
            solve(1,N,1,N);
            System.out.println(sb);
        }

        static void solve(int is, int ie, int ps, int pe) {
            if(ie < is || pe < ps) return;
            int root = postOrder[pe];
            int rIdx = index[root];
            sb.append(root+" ");

            int len = rIdx - is; // left 트리 길이
            // left 트리
            solve(is, rIdx-1, ps, ps+len-1);
            // right 트리
            solve(rIdx+1, ie, ps+len, pe-1);
        }
    }