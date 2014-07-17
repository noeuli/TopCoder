package com.noeuli.topcoder;

public class NumberGuessing {
    private static final String TAG = "NumberGuessing";
    private static final boolean LOGD = true;
    
    public int bestGuess(int range, int[] guesses, int numLeft) {
        if (LOGD) Log.d(TAG, "bestGuess(" + range + ", " + arr(guesses) + ", " + numLeft + ")");
        
        return 0;
    }
    
    private String arr(int[] array) {
        if (array==null) return "";
        String ret = "[";
        for (int i=0; i<array.length; i++) {
            ret += array[i] + " ";
        }
        ret += "]";
        return ret;
    }
}
