import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b1068 {
    static List<Integer>[] tree;
    static int deleteNode, leafCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] parent = new int[N];
        tree = new ArrayList[N];
        int root = -1;

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            parent[i] = sc.nextInt();
            if (parent[i] == -1) {
                root = i;
            } else {
                tree[parent[i]].add(i);
            }
        }

        deleteNode = sc.nextInt();

        if (deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int now) {
        if (now == deleteNode) return;

        int childCount = 0;

        for (int child : tree[now]) {
            if (child != deleteNode) {
                dfs(child);
                childCount++;
            }
        }

        // 자식 노드가 없으면 리프노드
        if (childCount == 0) {
            leafCount++;
        }
    }
}