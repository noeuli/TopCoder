package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
        int[][] arrayPrice = {
                {9,1,5,5,5,5,4,8,80},
                {17,50,2},
                {130,110,90,13,6,5,4,3,0},
        };
        /*
        0) Returns: 120
        Charge 80 to the one customer willing to pay 80.
        Charge 8 to the 2 customers willing to pay 8 or 9.
        Charge 5 to the 4 customers willing to pay 5.
        Charge 4 to the one customer willing to pay 4.
        Total sales revenue = 1*80 + 2*8 + 4*5 + 1*4. 
        (We can put the customer who is willing to pay 1 into any of these groups since he will not buy anything at these prices.)
        
        1) Returns: 69
        We use just three groups, each containing one customer. 
        We charge each customer the most she is willing to pay. 
        Total sales revenue = 1*17 + 1*50 + 1*2
        
        2) Returns: 346
        Charge each of the 4 customers willing to pay between 4 and 13 a price of 4, thereby getting a total of 16 from them. 
        Then charge the most we can to each of the three customers who are willing to pay a lot. 4*4 + 90 + 110 + 130 = 346
	    */

        int testCase = 0;
        int[] price = arrayPrice[testCase];

        Pricing testInstance = new Pricing();
        int ret = testInstance.maxSales(price);
		
		System.out.println(ret);
	}
}