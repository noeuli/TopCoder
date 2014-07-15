package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 147 Round 1 Div 1 Level 3 600pt
public class Flags {
    private static final String TAG = "Flags";
    private static final boolean LOGD = false;
    
    public long numStripes(String numFlags, String[] forbidden) {
        long stripes=0;
        long target = Long.valueOf(numFlags);
        long made = 0;
        
        // convert forbidden list
        ArrayList<ForbiddenItems> forbiddenList = getForbiddenList(forbidden);
        
        while (stripes < target) {
            if (made >= target) break;
            made += getNumOfCombinations(++stripes, forbiddenList);
            if (LOGD) Log.d(TAG, "getNumOfCombinations(" + stripes + ") accum=" + made);
        };
        
        if (LOGD) Log.d(TAG, "numStripes() made=" + made + " target=" + target + " stripes=" + stripes);
        
        return stripes;
    }

    private long getNumOfCombinations(long stripes, ArrayList<ForbiddenItems> forbiddenList) {
        int maxColors = forbiddenList.size();
        long numOfCombinations = 0;

        if (LOGD) Log.d(TAG, "getNumOfCombinations(" + stripes + ") maxColors=" + maxColors);
        
        if (stripes == 1) return maxColors;
        
        for (int c=0; c<maxColors; c++) {
            ForbiddenItems forbidC = forbiddenList.get(c);
            for (int i=0; i<stripes; i++) {
                boolean reject = false;
                for (int color=0; color<maxColors; color++) {
                    if (forbidC.hasColor(color)) {
                        reject = true;
                    }
                    if (reject==false) numOfCombinations++;
                    if (LOGD) Log.d(TAG, "c=" + c + " i=" + i + " color=" + color + " " + reject + " acc=" + numOfCombinations + " " + forbidC);
                }
            }
        }

        if (LOGD) Log.d(TAG, "getNumOfCombinations(" + stripes + ") returns " + numOfCombinations);

        return numOfCombinations;
    }
    
    class ForbiddenItems {
        private ArrayList<Integer> mForbiddenColors;
        
        public ForbiddenItems(String forbiddenColorString) {
            mForbiddenColors = new ArrayList<Integer>();
            if (forbiddenColorString==null) {
                if (LOGD) Log.e(TAG, "ForbiddenItems class constructor error! Input string is null!");
            } else {
                String[] list = forbiddenColorString.split(" ");
                for (int i=0; i<list.length; i++) {
                    mForbiddenColors.add(Integer.valueOf(list[i]));
                }
            }
        }
        
        public boolean hasColor(int color) {
            return mForbiddenColors.contains(color);
        }
        
        public String toString() {
            String msg = "";
            for (int i=0; i<mForbiddenColors.size(); i++) {
                msg += mForbiddenColors.get(i) + " ";
            }
            return msg;
        }
    };
    
    private ArrayList<ForbiddenItems> getForbiddenList(String[] forbidden) {
        ArrayList<ForbiddenItems> list = new ArrayList<ForbiddenItems>();
        
        if (forbidden != null) {
            for (int i=0; i<forbidden.length; i++) {
                list.add(new ForbiddenItems(forbidden[i]));
            }
        }
        
        return list;
    }
    
}
