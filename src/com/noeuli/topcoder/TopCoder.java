package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    int[][] arrayArrivals = {
	            { 10, 0, 0, 4, 20 },
	            { 0, 0, 0 },
	            { 100, 100 },
	            { 27, 0, 0, 0, 0, 9 },
	            { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 },
	    };
	    int[] arrayNumPerDay = {
	            8,
	            10,
	            10,
	            9,
	            3,
	    };
        /*
        0) Returns: 6
        1) Returns: 0
        2) Returns: 20
        3) Returns: 4
        4) Returns: 15
	    */

        int testCase = 4;
        int[] arrivals = arrayArrivals[testCase];
        int numPerDay = arrayNumPerDay[testCase];

        WidgetRepairs testInstance = new WidgetRepairs();
        int ret = testInstance.days(arrivals, numPerDay);
		
		System.out.println(ret);
	}
}