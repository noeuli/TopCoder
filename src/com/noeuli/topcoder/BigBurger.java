package com.noeuli.topcoder;

import java.util.Arrays;

// SRM 149 Div 2 Level 2, - 499.94
// SRM 149 Div 1 Level 1, - 249.97
public class BigBurger {
    public int maxWait(int[] arrival, int[] service) {
        int count = arrival.length;
        int[] wait = new int[count];
        int[] leave = new int[count];
        
        for (int i=0; i<count; i++) {
            if (i==0 || arrival[i]>leave[i-1]){
                wait[i] = 0;
                leave[i] = arrival[i] + service[i];
            } else {
                wait[i] = leave[i-1] - arrival[i];
                leave[i] = arrival[i] + wait[i] + service[i];
            }
        }
        
        Arrays.sort(wait);
        
        return wait[wait.length-1];
    }
}
/* test script
int[][] arrayArrival = {
{3,3,9},
{182},
{2,10,11},
{2,10,12},
};
int[][] arrayService = {
{2,15,14},
{11},
{3,4,3},
{15,1,15},
};

/ *
0) Returns: 11
Two customers arrive at time 3. The first one waits 0 time, orders, and is served after 2 minutes, leaving at time 5. The second one then orders and is served at time 20. Meanwhile a customer arrives at time 9 and waits until the second customer leaves. This last customer then orders at time 20, and is served and leaves at time 20+14 = 34. The first customer waited 0 minutes, the second waited 2 minutes (from time 3 to time 5), and the last customer waited 11 minutes (from time 9 to time 20).
1) Returns: 0
The first customer never needs to wait.
2) Returns: 3
The third customer needs to wait from time 11 to time 14. Neither of the other customers needs to wait at all.
3) Returns: 7
The second customer waits the longest.
* /

int testCase = 3;
int[] arrival = arrayArrival[testCase];
int[] service = arrayService[testCase];

BigBurger testInstance = new BigBurger();
int ret = testInstance.maxWait(arrival, service);
*/