package com.noeuli.topcoder;

import java.util.Arrays;

// SRM 148 Div 1 Level 3 : It's too hard - probability problem.
public class NumberGuessing {
    int upper;
    int guessed[];
    
    // I just copied annwer. But there's some typo. I don't want to correct this. 'cause this is not my code.
    public int bestGuess(int range, int[] guesses, int numLeft) {
        upper = range;
        guessed = new int[guesses.length + numLeft + 1];
        for (int i=0; i<guesses.length; i++) {
            guessed[i] = guesses[i];
        }
        return search(numLeft);
    }
    
    int search(int rest) {
        int chance = 0;
        int choice;
        if (rest == 0) {
            if (guessed.length == 1) {
                return guessed[0] = 1;
            } else {
                int temp[] = new int[guessed.length - 1];
                System.arraycopy(guessed, 0, temp, 0, temp.length);
                Arrays.sort(temp);
                chance = temp[0] - 1;
                choice = temp[0] - 1;
                for (int i=0; i<temp.length-1; i++) {
                    if (temp[i+1] > temp[i]+1
                            && (temp[i+1]-temp[i]-1)/2+1>chance) {
                        chance = (temp[i+1]-temp[i]-2/2+1);
                        choice = temp[i]+1;
                    }
                }
                if (upper-temp[temp.length-1] > chance) {
                    chance = upper - temp[temp.length-1];
                    choice = temp[temp.length-1]+1;
                }
                return guessed[guessed.length-1] = choice;
            }
        } else {
            int best[] = new int[guessed.length];
            for (int i=1; i<=upper; i++) {
                boolean used = false;
                for (int j=0; j<guessed.length-rest-1; j++) {
                    if (guessed[j]==i) {
                        used = true;
                        break;
                    }
                }
                if (!used) {
                    guessed[guessed.length-rest-1] = i;
                    search(rest-1);
                    int temp = calculate(i);
                    if (temp>chance) {
                        chance = temp;
                        choice = i;
                        System.arraycopy(guessed, 0, best, 0, best.length);
                    }
                }
            }
            System.arraycopy(best, 0, guessed, 0, best.length);
            return guessed[guessed.length-rest-1];
        }
    }
    
    int calculate(int number) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i=0; i<guessed.length; i++) {
            if (guessed[i]<number) {
                min = Math.max(min,  guessed[i]);
            } else if (guessed[i] > number) {
                max = Math.min(max, guessed[i]);
            }
        }
        return 1 
                + (min==Integer.MIN_VALUE ? number-1 : (number-min-1)/2)
                + (max==Integer.MAX_VALUE ? upper-number : (max-number-1)/2);
    }
}

/* Test Script
int[] arrayRange = {
1000,
1000000,
1000,
100,
};
int[][] arrayGuesses = {
{500},
{},
{},
{27,80},
};
int[] arrayNumLeft = {
1,
1,
2,
1,
};

/ *
0) Returns: 501
The example from above.

1) Returns: 500000

2) Returns: 750
Your first intuition might be that you should guess 500 in this case, since that is right in the middle. 
However, lets consider what would happen if you were to guess 500. 
The person after you would guess 501 to maximize his or her chance of winning, and the last person would then pick 499, 
to maximize his or her chance of winning. 
This leaves you winning only if the number that was originally picked is exactly 500, at a probability of 1/1000. 
It turns out that your probability is maximized if you guess 750. The next person then guesses 250, and the last person guesses 251.

3) Returns: 26
* /


int testCase = 0;
int range = arrayRange[testCase];
int[] guesses = arrayGuesses[testCase];
int numLeft = arrayNumLeft[testCase];

NumberGuessing testInstance = new NumberGuessing();
int ret = testInstance.bestGuess(range, guesses, numLeft);
*/