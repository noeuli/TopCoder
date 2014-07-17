package com.noeuli.topcoder;

public class CircleGame {
    private static final String TAG = "CircleGame";
    private static final boolean LOGD = true;
    
    public int cardsLeft(String deck) {
        int count = deck.length();
        int maxLength = count;
        int[] cards = new int[count];

        // Convert input values.
        for (int i=0; i<maxLength; i++) {
            char number = deck.charAt(i);
            cards[i] = (number=='A' ? 1 : number=='T' ? 10 : number=='J' ? 11 : number=='Q' ? 12 : number=='K' ? 13 : number-'0');
        }

        // Remove 'K'
        for (int i=0; i<maxLength; i++) {
            if (cards[i] == 13) {
                cards[i] = 0;
                count--;
            }
        }
        
        // No more compare list
        if (count<2) return count;
        
        // Compare a pair in sequence - first round
        int first=0;
        int second=-1;
        for (first=0, second=-1; first<maxLength; first++) {
            if (cards[first]==0) continue;
            if (second==-1) {
                second = first;
                continue;
            }
            if (cards[first]+cards[second]==13) {
                cards[first]=0;
                cards[second]=0;
                count-=2;
                // finish this!
                if (count<2) return count;
                for(;second>=0 && cards[second]==0;second--) ;
                if (second>=0 && cards[second]==0) second=-1;
                continue;
            } else {
                second=first;
                continue;
            }
        }

        Log.d(TAG, "first=" + first + " seoncd=" + second + " count=" + count);
        
        // No more compare list
        if (count<2) return count;

        // debug print interim
        for (int i=0; i<maxLength; i++) {
            Log.d(TAG, "cards[" + i + "] " + cards[i]);
        }
        
        // second round - find first again
        for(first=0; first<maxLength; first++) {
            if (cards[first]==0) continue;
            if (cards[first]+cards[second]==13) {
                cards[first]=0;
                cards[second]=0;
                count-=2;
                // find valid second card
                for(;cards[second]==0 && second>first;second--) ;
                continue;
            } else {
                // finish this!
                Log.d(TAG, "2nd print!! first=" + first + " seoncd=" + second + " count=" + count);
                // debug print interim
                for (int i=0; i<maxLength; i++) {
                    Log.d(TAG, "cards[" + i + "] " + cards[i]);
                }
                return count;
            }
        }
        
        Log.d(TAG, "3rd print!! first=" + first + " seoncd=" + second + " count=" + count);
        
        // No more compare list
        if (count<2) return count;

        // debug print interim
        for (int i=0; i<maxLength; i++) {
            Log.d(TAG, "cards[" + i + "] " + cards[i]);
        }
        
        /*
        int rear = maxLength-1;
        int front = 0;
        for (int i=maxLength; i>0; i--) {
            if (cards[i-1]==0) continue;
        }
        */
        
        return count;
    }
}
/* test script

String[] arrayDeck = {
        "KKKKKKKKKK",
        "KKKKKAQT23",
        "KKKKATQ23J",
        "AT68482AK6875QJ5K9573Q",
        "AQK262362TKKAQ6262437892KTTJA332",
        "J92J43KT5T879QA2QK3",
        "7879J4JQK24Q46K2A3TQ7T4256632TQ738JA6KA8K959J5T895",
        "AQKTQKATQAKTKTQTQTAKTQKATQKATQ",
        "A23456789TJQA23456789TJQ",
        
};

/ *
0) Returns: 0
All K cards are always removed from the deck.

1) Returns: 1
The K cards are removed, leaving AQT23. 
AQ are then removed because they add up to 13, leaving T23. 
Since the deck wraps around and T and 3 add up to 13, they are also removed, just leaving the 2.

2) Returns: 6
Only the K cards can be removed.

3) Returns: 4
The remaining deck is 6875.

4) Returns: 24

5) Returns: 9
6) Returns: 42
7) Returns: 13
8) Returns: 0
* /

int testCase = 8;
String deck = arrayDeck[testCase];

CircleGame testInstance = new CircleGame();
int ret = testInstance.cardsLeft(deck);
*/