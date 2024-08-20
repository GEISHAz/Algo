import java.util.*;

class p배달 {
    class Node implements Comparable<Node> {
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] adj = new ArrayList[N + 1];
        int[] dijkstra = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
            dijkstra[i] = Integer.MAX_VALUE;
        }

        for (int[] arr : road) {
            adj[arr[0]].add(new Node(arr[1], arr[2]));
            adj[arr[1]].add(new Node(arr[0], arr[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dijkstra[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.to;

            if (isVisited[curNode]) {
                continue;
            }
            isVisited[curNode] = true;

            for (Node neighbor : adj[curNode]) {
                if (dijkstra[neighbor.to] > dijkstra[curNode] + neighbor.distance) {
                    dijkstra[neighbor.to] = dijkstra[curNode] + neighbor.distance;
                    pq.add(new Node(neighbor.to, dijkstra[neighbor.to]));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (dijkstra[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}