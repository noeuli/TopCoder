package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    
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

        /*
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
        7) 13 - oob
        8) 0 - oob
	    */

        int testCase = 8;
        String deck = arrayDeck[testCase];

        CircleGame testInstance = new CircleGame();
        int ret = testInstance.cardsLeft(deck);
		
		System.out.println(ret);
	}
}