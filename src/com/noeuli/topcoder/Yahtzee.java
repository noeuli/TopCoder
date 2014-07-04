package com.noeuli.topcoder;

public class Yahtzee {
	public int maxPoints(int[] toss) {
		int result = 0;
		int[] count = new int[] { 0, 0, 0, 0, 0, 0 };
		
		for (int i=0; i<toss.length; i++) {
			count[toss[i]-1]++;
		}
		
		for (int i=0; i<6; i++) {
			result = Math.max(result,  (i+1)*count[i]);
		}
		
		return result;
	}

}
