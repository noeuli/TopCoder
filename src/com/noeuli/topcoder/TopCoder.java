package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
        int[] arrayRange = {
                1000,
                1000000,
                1000,
                100,
                20,
        };
        int[][] arrayGuesses = {
                {500},
                {},
                {},
                {27,80},
                {8, 13},
        };
        int[] arrayNumLeft = {
                1,
                1,
                2,
                1,
                2,
        };

        /*
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
	    */

	    
        int testCase = 4;
        int range = arrayRange[testCase];
        int[] guesses = arrayGuesses[testCase];
        int numLeft = arrayNumLeft[testCase];

        NumberGuessing testInstance = new NumberGuessing();
        int ret = testInstance.bestGuess(range, guesses, numLeft);
		
		System.out.println(ret);
	}
}