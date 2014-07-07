package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 147 Round 1 Div 1 Level 3 600pt
public class Flags {
    public long numStripes(String numFlags, String[] forbidden) {
        long stripes=0;
        long target = Long.valueOf(numFlags);
        
        int maxColors = forbidden.length;
        long made = 0;
        
        // convert forbidden list
        ArrayList<ForbiddenItems> forbiddenList = getForbiddenList(forbidden);
        
        while (++stripes < target /*Long.MAX_VALUE*/) {
            if (made >= target) break;
            made += getNumOfCombinations(stripes, forbiddenList);
        };
        
        return stripes;
    }
    
    class ForbiddenItems {
        
    };
    
    private ArrayList<ForbiddenItems> getForbiddenList(String[] forbidden) {
        return new ArrayList<ForbiddenItems>();
    }
    
    private long getNumOfCombinations(long stripes, ArrayList<ForbiddenItems> forbiddenList) {
        int maxColors = forbiddenList.size();
        long numOfCombinations = maxColors;
        
        if (stripes>1) {
            
        }
        
        final String SP = " ";
                
        for (int color=0; color<maxColors; color++) {
            boolean bForbidden = false;
            bForbidden = isForbidden(color, forbidden[color]);

            // make forbiddenlist
            ArrayList<Integer> forbiddenColors = new ArrayList<Integer>();
            String forbiddenPattern = forbidden[color];
            String[] list = forbiddenPattern.split(SP);
            for(String value : list) {
                forbiddenColors.add(Integer.valueOf(value));
            }
        
        
        }
        

        
        return numOfCombinations;
    }
    
    private boolean isForbidden(int color, String forbidden) {
        boolean bForbidden = false;
        
        return bForbidden;
    }

}
