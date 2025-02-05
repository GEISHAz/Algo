package Programmers;

import java.util.*;

class p_JoyStick {
	int calculate(char c){
		return Math.min(c-'A','Z'-c+1);
	}
	public int solution(String name) {
		int answer = 0;
		int size = name.length();
		int move = size - 1;
		int[] count = new int[size];
		for(int i = 0 ; i < size ; i++){
			char c = name.charAt(i);
			answer += calculate(c);
			if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
				int endA = i + 1;
				while(endA < name.length() && name.charAt(endA) == 'A')
					endA++;
				move = Math.min(move, i * 2 + (name.length() - endA));
				move = Math.min(move, i + (name.length() - endA) * 2);
			}
		}
		return answer+move;
	}
}