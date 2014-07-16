package com.noeuli.topcoder;

public class DivDigits {
    public int howMany(int number) {
        int[] mark = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int value = number;
        do {
            int mod = value%10;
            if (mod != 0 && number%mod==0) {
                mark[mod]++;
            }
            value /= 10;
        } while (value/10>0);
        if (number%value==0) mark[value]++;
        
        int count=0;
        for(int i=0; i<10; i++) count+=mark[i];
        
        return count;
    }
}

/* test script
int[] arrayNumber = {
        12345,
        661232,
        52527,
        730000000,
};
/ *
case 0 Returns: 3
12345 is divisible by 1, 3, and 5.

case 1 Returns: 3
661232 is divisible by 1 and 2.

case 2 Returns: 0
52527 is not divisible by 5, 2, or 7.

case 3 Returns: 0
Nothing is divisible by 0. In this case, the number is also not divisible by 7 or 3.
* /

int testCase = 3;
int number = arrayNumber[testCase];

DivDigits testInstance = new DivDigits();
long ret = testInstance.howMany(number);
*/
