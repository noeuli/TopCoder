package com.noeuli.topcoder;

import java.util.Arrays;

// SRM 149 Div 2 Level 3
public class Pricing {
    public int maxSales(int[] price) {
        int size = price.length;
        int maxRevenue = 0;
        
        if (size<4) {
            for(int i=0; i<size; i++)
                maxRevenue += price[i];
            return maxRevenue;
        }
        
        int[] sorted = Arrays.copyOf(price,  size);
        Arrays.sort(sorted);
        int[] groups = new int[4];
        int index = size;
        int group = 0;
        while(--index>=0) {
            groups[group] = price[index];
        }
        
        return maxRevenue;
    }
}
