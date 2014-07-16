package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 147 Round 1 Div 1 Level 3 600pt
public class Flags {
//    private ArrayList<ForbiddenItems> mForbiddenList;
    
    /* my one
    public long numStripes(String numFlags, String[] forbidden) {
        long stripes=0;
        long target = Long.valueOf(numFlags);
        long made = 0;
        
        // convert forbidden list
        mForbiddenList = makeForbiddenList(forbidden);
        
        while (stripes < target) {
            if (made >= target) break;
            made += getNumOfCombinations(++stripes);
        };
        
        return stripes;
    }
    */
    
    /* run script
     * 
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

        case 0 Returns: 3
        case 1 Returns: 6
        case 2 Returns: 50000000000000000
        case 3 Returns: 40
        case 4 Returns: 4999999999999996
        case 5 Returns: 1

        int testCase = 4;
        String numFlags = arrayNumFlags[testCase];
        String[] forbidden = arrayForbidden[testCase];

        Flags testInstance = new Flags();
        long ret = testInstance.numStripes(numFlags, forbidden);
        System.out.println(ret);
    */
    
    private String str(String[] arr) {
        if (arr==null) return "null";
        String ret = "[";
        for (int i=0; i<arr.length; i++)
            ret += arr[i] + ";";
        return ret + "]";
    }
    
    // best answer
    public long numStripes(String numFlags, String[] forbidden) {
        long total = 0;
        long nStripes = 1;
        long nFlags = Long.parseLong(numFlags);
        int nColors = forbidden.length;
        boolean[][] forbiddenFlags = new boolean[nColors][nColors];
        boolean orderOfOne = true;
        int unforbiddenColors = 0;
        
        Log.d("numStripes(" + numFlags + ", " + str(forbidden));
        
        for (int i=0; i<nColors; i++) {
            String[] fArr = forbidden[i].split(" ");
            Log.d("i=" + i + " fArr=" + str(fArr));
            int order = nColors;
            for (int j=0; j<fArr.length; j++) {
                int f = Integer.parseInt(fArr[j]);
                order--;
                forbiddenFlags[i][f] = true;
                forbiddenFlags[f][i] = true;
            }
            
            if (order>1) orderOfOne = false;
            if (order>0) unforbiddenColors++;
        }
        
        if (orderOfOne) {
            int forbiddenColors = nColors - unforbiddenColors;
            Log.d("orderOfOne=" + forbiddenColors);
            return ((nFlags-forbiddenColors)/unforbiddenColors)+((nFlags-forbiddenColors)%unforbiddenColors==0?0:1);
        }
        
        long[][] possibleFlags = new long[nColors][2];
        
        for (int i=0; i<nColors; i++) 
            possibleFlags[i][1] = 1;
        
        while (total<nFlags) {
            for (int i=0; i<nColors; i++) {
                total += possibleFlags[i][1];
                possibleFlags[i][0] = possibleFlags[i][1];
                possibleFlags[i][1] = 0;
                if (total >= nFlags) {
                    Log.d("total1=" + total);
                    return nStripes;
                }
            }
            
            for (int i=0; i<nColors; i++) {
                for (int j=0; j<nColors; j++) {
                    if (!forbiddenFlags[i][j]) {
                        possibleFlags[i][1] += possibleFlags[j][0];
                    }
                }
            }
            Log.d("total2=" + total);
            nStripes++;
        }
        
        return nStripes;
    }
    /*
    private long getCombination(String tag, long currStripe, long maxStripes, int prevColor, ForbiddenItems prevForbidItem) {
        long ret = 0;
        int maxColors = mForbiddenList.size();

        if (maxStripes==1) {
            return maxColors;
        }

        String prefix = "";
        for (int i=0; i<currStripe; i++) prefix += "-";
        
        for (int color=0; color<maxColors; color++) {
            if (currStripe>0 && prevForbidItem.hasColor(color)) {
                continue;
            } else {
                if (currStripe+1 < maxStripes) {
                    ForbiddenItems forbidC = mForbiddenList.get(color);
                    if (currStripe==0) tag = String.valueOf(color);
                    else tag += " " + color;
                    long get = getCombination(tag, currStripe+1, maxStripes, color, forbidC);
                    ret += get;
                } else {
                    ret++;
                }
            }
        }
        
        return ret;
    }

    private long getNumOfCombinations(long stripes) {
        int maxColors = mForbiddenList.size();
        long numOfCombinations = 0;

    
        int color = 0;
        String tag = String.valueOf(color);
        ForbiddenItems forbidC = mForbiddenList.get(color);
        numOfCombinations += getCombination(tag, 0, stripes, -1, forbidC);


        return numOfCombinations;
    }
    
    class ForbiddenItems {
        private ArrayList<Integer> mForbiddenColors;
        
        public ForbiddenItems(String forbiddenColorString) {
            mForbiddenColors = new ArrayList<Integer>();
            if (forbiddenColorString==null) {
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
    */
}
