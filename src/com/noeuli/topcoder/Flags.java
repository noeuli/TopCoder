package com.noeuli.topcoder;

// SRM 147 Round 1 Div 1 Level 3 600pt
public class Flags {
    public long numStripes(String numFlags, String[] forbidden) {
        long stripes=1;
        long target = Long.valueOf(numFlags);
        
        int maxColors = forbidden.length;
        int acc = 0;
        for (stripes=1; stripes<=maxColors; stripes++) {
            long numOfCombinations = getNumOfCombinations(stripes, forbidden);
            acc += numOfCombinations;
            if (target <= acc) break;
        }
        return stripes;
    }
    
    private long getNumOfCombinations(long stripes, String[] forbidden) {
        int maxColors = forbidden.length;
        long numOfCombinations = maxColors;
        
        if (stripes>1) {
            
        }
        
        return numOfCombinations;
    }

}
