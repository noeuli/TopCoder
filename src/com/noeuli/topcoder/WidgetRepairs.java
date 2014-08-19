package com.noeuli.topcoder;

public class WidgetRepairs {
    public int days(int[] arrivals, int numPerDay) {
        int workingDays = 0;
        
        int worksLeft = 0;
        for (int i=0; i<arrivals.length; i++) {
            worksLeft += arrivals[i];
            if (worksLeft>0) {
                worksLeft -= numPerDay;
                workingDays++;
                if (worksLeft<0) worksLeft = 0;
            }
        }
//        System.out.println("worksLeft=" + worksLeft + " workingDays=" + workingDays + " ceil=" + Math.ceil((float)worksLeft/numPerDay) + " floor=" + Math.floor((float)worksLeft/numPerDay));
        if (worksLeft>0) {
            workingDays += (int)Math.ceil((float)worksLeft/numPerDay);
        }
        return workingDays;
    }
}
/* test script
int[][] arrayArrivals = {
{ 10, 0, 0, 4, 20 },
{ 0, 0, 0 },
{ 100, 100 },
{ 27, 0, 0, 0, 0, 9 },
{ 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 },
};
int[] arrayNumPerDay = {
8,
10,
10,
9,
3,
};
/ *
0) Returns: 6
1) Returns: 0
2) Returns: 20
3) Returns: 4
4) Returns: 15
* /

int testCase = 4;
int[] arrivals = arrayArrivals[testCase];
int numPerDay = arrayNumPerDay[testCase];

WidgetRepairs testInstance = new WidgetRepairs();
int ret = testInstance.days(arrivals, numPerDay);
*/