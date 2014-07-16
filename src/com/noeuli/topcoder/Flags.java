package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 147 Round 1 Div 1 Level 3 600pt
public class Flags {
    private static final String TAG = "Flags";
    private static final boolean LOGD = false;
    
    private ArrayList<ForbiddenItems> mForbiddenList;
    
    public long numStripes(String numFlags, String[] forbidden) {
        long stripes=0;
        long target = Long.valueOf(numFlags);
        long made = 0;
        
        // convert forbidden list
        mForbiddenList = makeForbiddenList(forbidden);
        
        while (stripes < target) {
            if (made >= target) break;
            made += getNumOfCombinations(++stripes);
            if (LOGD) {
                Log.d(TAG, "getNumOfCombinations(" + stripes + ") accum=" + made + "\n");
            }
        };
        
        Log.d(TAG, "numStripes() made=" + made + " target=" + target + " stripes=" + stripes);
        
        return stripes;
    }
    
    private long getCombination(String tag, long currStripe, long maxStripes, int prevColor, ForbiddenItems prevForbidItem) {
        long ret = 0;
        int maxColors = mForbiddenList.size();

        if (maxStripes==1) {
            if (LOGD) Log.d(TAG, "getCombination([[" + tag + "]], " + currStripe + ", " + maxStripes + ", " + prevColor + ", [" + prevForbidItem + "]) returns maxColor(" + maxColors + ")");
            return maxColors;
        }

        String prefix = "";
        for (int i=0; i<currStripe; i++) prefix += "-";
        
        for (int color=0; color<maxColors; color++) {
            if (currStripe>0 && prevForbidItem.hasColor(color)) {
                if (LOGD) Log.d(TAG, prefix + "getCombination([[" + tag + " " + color + "]], " + currStripe + ", " + maxStripes + ", " + prevColor + ", [" + prevForbidItem + "]) Forbidden color " + color + "; continue.");
                continue;
            } else {
                if (currStripe+1 < maxStripes) {
                    ForbiddenItems forbidC = mForbiddenList.get(color);
                    if (currStripe==0) tag = String.valueOf(color);
                    else tag += " " + color;
                    long get = getCombination(tag, currStripe+1, maxStripes, color, forbidC);
                    ret += get;
                    if (LOGD) Log.d(TAG, prefix + "getCombination([[" + tag + "]], " + currStripe + ", " + maxStripes + ", " + prevColor + ", [" + prevForbidItem + "]) color=" + color + " ret=" + ret + "; get=" + get);
                } else {
                    ret++;
                    if (LOGD) Log.d(TAG, prefix + "getCombination([[" + tag + " " + color + "]], " + currStripe + ", " + maxStripes + ", " + prevColor + ", [" + prevForbidItem + "]) color=" + color + " ret=" + ret);
                }
            }
        }
        
        if (LOGD) Log.d(TAG, prefix + "getCombination([[" + tag + "]], " + currStripe + ", " + maxStripes + ", " + prevColor + ", [" + prevForbidItem + "])  ret=" + ret);
        return ret;
    }

    private long getNumOfCombinations(long stripes) {
        int maxColors = mForbiddenList.size();
        long numOfCombinations = 0;

        if (LOGD) Log.d(TAG, "getNumOfCombinations(" + stripes + ") maxColors=" + maxColors);
    
        int color = 0;
        String tag = String.valueOf(color);
        ForbiddenItems forbidC = mForbiddenList.get(color);
        numOfCombinations += getCombination(tag, 0, stripes, -1, forbidC);

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
    
    private ArrayList<ForbiddenItems> makeForbiddenList(String[] forbidden) {
        ArrayList<ForbiddenItems> list = new ArrayList<ForbiddenItems>();
        
        if (forbidden != null) {
            for (int i=0; i<forbidden.length; i++) {
                list.add(new ForbiddenItems(forbidden[i]));
            }
        }
        
        return list;
    }
    
}
