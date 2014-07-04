package com.noeuli.topcoder;

public class VersionReadTest {
	public void test() {
		String name = "4.2.1.5";
		//String name = "05.02";
		final int MAJOR = 4;
		final int MINOR = 2;
		final int FUNCTION = 1;
		final int BUILD = 5;
		
		final String DOT = ".";
        int len = name.length();
        int firstDot = name.indexOf(DOT);
        int secondDot = (firstDot > -1 ? name.indexOf(DOT, firstDot+1) : -1);
        int thirdDot = (secondDot > -1 ? name.indexOf(DOT, secondDot+1) : -1);

        String ret;

        ret = " first=" + firstDot + " second=" + secondDot + " third=" + thirdDot + " len=" + len;
		System.out.println(ret);

		if (firstDot < 0 || secondDot < 0 || thirdDot < 0) {
            ret = "not supported.";
        } else {
        	ret = "Not SUPPORTED.";
        	
        	String sub1 = name.substring(0, firstDot);
        	String sub2 = name.substring(firstDot+1, secondDot);
        	String sub3 = name.substring(secondDot+1, thirdDot);
        	String sub4 = name.substring(thirdDot+1, len);
        	
        	int verMajor = Integer.valueOf(sub1);
        	int verMinor = Integer.valueOf(sub2);
        	int verFunction = Integer.valueOf(sub3);
        	int verBuild = Integer.valueOf(sub4);

            if (verMajor > MAJOR)
            	ret = "Major Supported.";
            else if (verMajor == MAJOR) {
	            if (verMinor > MINOR)
	            	ret = "Minor Supported.";
	            else if (verMinor == MINOR) {
	            	if (verFunction > FUNCTION)
	            		ret = "Fuction Supported.";
	            	else if (verFunction == FUNCTION) {
	            		if (verBuild >= BUILD)
	            			ret = "Build Supported.";
	            	}
	            }
            }
            	
            ret += " major=" + verMajor + " minor=" + verMinor + " function=" + verFunction + " build=" + verBuild;
        }

        ret += " first=" + firstDot + " second=" + secondDot + " third=" + thirdDot;
		System.out.println("return=[" + ret + "]");
	}
}
