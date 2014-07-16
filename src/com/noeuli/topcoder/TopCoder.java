package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    Flags testInstance = new Flags();
	    
	    String[] arrayNumFlags = {
	            "10",
	            "100",
	            "100000000000000000",
	            "10000000000000000",
	            "10000000000000000",
	            "5",
	    };
	    String[][] arrayForbidden = {
	            {"0","1 2","1 2"},
	            {"0","1","2"},
	            {"0","1"},
	            {"0 1", "0 1", "2 3 4", "2 3 4", "2 3 4"},
	            {"0 1 2 3 4 5 6 7 8 9", "0 1 3 4 5 6 7 8 9", "0 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", 
	                "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", 
	                "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9"},
                {"0","1","2","3","4","5"},
	    };

	    /*
	    case 0 Returns: 3
	    case 1 Returns: 6
	    case 2 Returns: 50000000000000000
	    case 3 Returns: 40
	    case 4 Returns: 4999999999999996
	    case 5 Returns: 1
	    */

        int testCase = 2;
        String numFlags = arrayNumFlags[testCase];
        String[] forbidden = arrayForbidden[testCase];

		long ret = testInstance.numStripes(numFlags, forbidden);
		System.out.println(ret);
	}
}