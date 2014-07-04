package com.noeuli.topcoder;

public class JavaTest {
	public static void main(String[] args) {
	    PeopleCircle testInstance = new PeopleCircle();
		int[] input = { 
			1, 0, 245
		};
		//int input2 = 2;
		String ret = testInstance.order(input[0], input[1], input[2]);
		System.out.println(ret);
	}
}