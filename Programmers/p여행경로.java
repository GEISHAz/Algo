package Programmers;

import java.util.*;

class p여행경로 {
	boolean[] isVisited;
	ArrayList<String> routes;
	private void dfs(String now, String route, String[][] tickets ,int cnt){
		if(cnt > tickets.length){
			routes.add(route);
			return;
		}
		for(int i = 0 ; i < tickets.length ; i++){
			if(now.equals(tickets[i][0]) && !isVisited[i]){
				isVisited[i] = true;
				dfs(tickets[i][1],route+" "+tickets[i][1],tickets,cnt+1);
				isVisited[i] = false;
			}
		}
	}
	public String[] solution(String[][] tickets) {
		String[] answer;
		isVisited = new boolean[tickets.length];
		routes = new ArrayList<>();
		int cnt = 0;

		dfs("ICN","ICN",tickets,cnt+1);

		Collections.sort(routes);
		answer = routes.get(0).split(" ");
		return answer;
	}
}