package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    Flags testInstance = new Flags();
	    String numFlags = "100";
	    String[] forbidden = {
	        "0", "1", "2"
	    };
		long ret = testInstance.numStripes(numFlags, forbidden);
		System.out.println(ret);
	}
}