package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    Dragons testInstance = new Dragons();
		int[] input = { 
			1, 2, 3, 4, 5, 6
//		    0, 0, 4, 0, 0, 0
		};
		int input2 = 45;
		String ret = testInstance.snaug(input, input2);
		System.out.println(ret);
	}
}