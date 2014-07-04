package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    Dragons testInstance = new Dragons();
		int[] input = { 
			0, 0, 4, 0, 0, 0
		};
		int input2 = 2;
		String ret = testInstance.snaug(input, input2);
		System.out.println(ret);
	}
}