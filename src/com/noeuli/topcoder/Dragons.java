package com.noeuli.topcoder;

import java.math.BigInteger;

// SRM 147 Div 1 Level 2
public class Dragons {
	private static final int F = 0;	// Front
	private static final int B = 1;	// Back
	private static final int U = 2;	// Up -the Snaug
	private static final int D = 3;	// Down
	private static final int L = 4;	// Left
	private static final int R = 5;	// Right
	private static final int SNAUG = U;

	class Fraction {
	    private BigInteger numerator; // above a line
	    private BigInteger denominator;   // below a line
	    
	    public Fraction() {
	        numerator = BigInteger.ZERO;
	        denominator = BigInteger.ONE;
	    }
	    
	    public Fraction (BigInteger value) {
	        numerator = value;
	        denominator = BigInteger.ONE;
	    }
	    
	    public Fraction (BigInteger num, BigInteger den) {
	        numerator = num;
	        denominator = den;
	    }
	    
	    public Fraction (Fraction a) {
	        numerator = a.getNumerator();
	        denominator = a.getDenominator();
	    }
	    
	    public Fraction add(Fraction a) {
	        numerator = numerator.multiply(a.getDenominator()).add(denominator.multiply(a.getNumerator()));
	        denominator = denominator.multiply(a.getDenominator());
	        return reduce();
	    }
	    
	    public Fraction multiply(Fraction a) {
	        this.numerator = numerator.multiply(a.getNumerator());
	        this.denominator = denominator.multiply(a.getDenominator());
	        return reduce();
	    }
	    
	    public void setValue(BigInteger value) {
	        numerator = value;
	        denominator = BigInteger.ONE;
	    }
	    
	    public BigInteger getNumerator() {
	        return numerator;
	    }
	    
	    public BigInteger getDenominator() {
	        return denominator;
	    }
	    
	    public Fraction reduce() {
	        BigInteger gcd = numerator.gcd(denominator);
	        numerator = numerator.divide(gcd);
	        denominator = denominator.divide(gcd);
	        return this;
	    }
	    
	    public String toString() {
	        reduce();
	        if (BigInteger.ZERO.equals(numerator)) {
	            return "0";
	        } else if (BigInteger.ONE.equals(denominator)) {
	            return String.valueOf(numerator);
	        } else if (BigInteger.ZERO.equals(denominator)) {
	            return "Error. Divide by 0.";
	        } else {
	            return numerator + "/" + denominator;
	        }
	    }
	}
	
	public String snaug(int[] initialFood, int rounds) {
		String result = "";
		
		Fraction[] nextFood = new Fraction[6];
		Fraction[] currentFood = new Fraction[6];
		
		for (int i=0; i<6; i++) {
		    currentFood[i] = new Fraction(new BigInteger(String.valueOf(initialFood[i])));
		}
		
		if (rounds == 0) {
		    result = String.valueOf(initialFood[SNAUG]);
		    return result;
		}

		for (int i=0; i<rounds; i++) {
		    result = "";
		    for (int initial=0; initial<6; initial++) {
		        result += currentFood[initial] + " ";
		    }
		    result = "";
		    
			for (int dragon=0; dragon<6; dragon++) {
			    Fraction next = getFood(i, currentFood, dragon);
				nextFood[dragon] = next;
				result += nextFood[dragon].reduce() + " ";
			}
			
			for (int dragon=0; dragon<6; dragon++) {
				currentFood[dragon] = nextFood[dragon];
		    }
		}
		
		result = nextFood[SNAUG].reduce().toString();
		
		return result;
	}
	
	private Fraction getFood(int round, Fraction[] foods, int side) {
	    Fraction result;
		
		if (side<2) {
		    result = new Fraction(foods[U]);
		    result.add(foods[D]);
		    result.add(foods[L]);
		    result.add(foods[R]);
		} else if (side < 4) {
            result = new Fraction(foods[F]);
            result.add(foods[B]);
            result.add(foods[L]);
            result.add(foods[R]);
		} else {
            result = new Fraction(foods[F]);
            result.add(foods[B]);
            result.add(foods[U]);
            result.add(foods[D]);
		}
		result.multiply(new Fraction(BigInteger.ONE, new BigInteger(String.valueOf(4))));

		return result;
	}
}
