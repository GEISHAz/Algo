package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import java.util.*;

class p과제진행하기 {
	class Assignment {
		String name;
		int start;
		int playTime;

		public Assignment(String name, String start, String playTime) {
			this.name = name;
			String[] time = start.split(":");
			this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			this.playTime = Integer.parseInt(playTime);
		}

		public int getEndTime() {
			return start + playTime;
		}
	}

	public String[] solution(String[][] plansArr) {
		Assignment[] plans = new Assignment[plansArr.length];
		for (int i = 0; i < plansArr.length; i++) {
			plans[i] = new Assignment(plansArr[i][0], plansArr[i][1], plansArr[i][2]);
		}

		Arrays.sort(plans, (a, b) -> a.start - b.start);

		Stack<Assignment> stop = new Stack<>();
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < plans.length - 1; i++) {
			Assignment curPlan = plans[i];
			Assignment nextPlan = plans[i + 1];

			if (curPlan.getEndTime() > nextPlan.start) {
				curPlan.playTime = curPlan.getEndTime() - nextPlan.start;
				stop.push(curPlan);
			} else {
				answer.add(curPlan.name);
				int restTime = nextPlan.start - curPlan.getEndTime();

				while (restTime > 0 && !stop.isEmpty()) {
					Assignment stoppedPlan = stop.pop();
					if (stoppedPlan.playTime <= restTime) {
						answer.add(stoppedPlan.name);
						restTime -= stoppedPlan.playTime;
					} else {
						stoppedPlan.playTime -= restTime;
						stop.push(stoppedPlan);
						restTime = 0;
					}
				}
			}
		}

		answer.add(plans[plans.length - 1].name);
		while (!stop.isEmpty()) {
			answer.add(stop.pop().name);
		}

		return answer.toArray(new String[0]);
	}
}
