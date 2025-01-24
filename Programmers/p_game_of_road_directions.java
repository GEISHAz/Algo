package Programmers;

import java.util.*;


class p_game_of_road_directions {
    int[][] result;
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        Arrays.sort(nodes, (n1, n2) -> (n1.y == n2.y) ? n1.x - n2.x : n2.y - n1.y);

        Node root = nodes[0];
        for (int i = 1; i < size; i++) {
            insertNode(root, nodes[i]);
        }

        result = new int[2][size];

        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return result;
    }

    public void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }

    class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

}