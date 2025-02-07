package Programmers;

import java.util.*;

class p_Sheep_and_Wolf {
	int maxSheepCnt = 0;
	List<Integer>[] adjList;

	public int solution(int[] info, int[][] edges) {
		int n = info.length;
		adjList = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			adjList[edge[0]].add(edge[1]);
		}

		List<Integer> visitableNodes = new ArrayList<>();
		visitableNodes.add(0);

		dfs(info, visitableNodes, 0, 0, 0);
		return maxSheepCnt;
	}

	public void dfs(int[] info, List<Integer> visitableNodes, int idx, int sheepCnt, int wolfCnt) {

		if (info[idx] == 0) sheepCnt++;
		else wolfCnt++;

		if (wolfCnt >= sheepCnt) return;

		maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);

		List<Integer> nextNodes = new ArrayList<>(visitableNodes);
		nextNodes.remove(Integer.valueOf(idx));

		for (int child : adjList[idx]) {
			nextNodes.add(child);
		}

		for (int next : nextNodes) {
			dfs(info, new ArrayList<>(nextNodes), next, sheepCnt, wolfCnt);
		}
	}
}
