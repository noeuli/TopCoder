package com.noeuli.topcoder;

public class ExerciseMachine {
	public int getPercentages(String time) {
		int result = 0;
		int duration = Integer.valueOf(time.substring(0, 2)) * 3600
				+ Integer.valueOf(time.substring(3, 5)) * 60
				+ Integer.valueOf(time.substring(6, 8));
		int i=0;
		result=duration;
		while(result%100!=0) {
			i++;
			result += duration;
		}
		if (i==0)
			result = 99	;
		else
			result = 100/(i+1) -1;
		
		return result;
	}
}
