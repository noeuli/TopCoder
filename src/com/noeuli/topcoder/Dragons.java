package com.noeuli.topcoder;

// SRM 147 Div 1 Level 2
public class Dragons {
	
	private final int F = 0;	// Front
	private final int B = 1;	// Back
	private final int U = 2;	// Up -the Snaug
	private final int D = 3;	// Down
	private final int L = 4;	// Left
	private final int R = 5;	// Right
	
	public String snaug(int[] initialFood, int rounds) {
		String result = "";
		
		int[] nextFood = new int[6];
		int[] currentFood = initialFood;
		
		// debug {
		for (int i=0; i<6; i++) {
			result += currentFood[i] + " ";
		}
		System.out.println("initial foods=" + result);
		result = "";
		// }

		for (int i=0; i<rounds; i++) {
			for (int dragon=0; dragon<6; dragon++) {
				nextFood[dragon] = getFood(i, currentFood, dragon);
				result += nextFood[dragon] + " ";
			}
			
			// debug {
			System.out.println("round " + i + " foods=" + result);
			result = "";
			// }
			
			for (int dragon=0; dragon<6; dragon++) 
				currentFood[dragon] = nextFood[dragon]/4;
		}
		
		// debug {
		result = "";
		for (int i=0; i<6; i++) {
			result += nextFood[i] + " ";
		}
		result += "/" + (int) Math.pow(4, rounds);
		// }
		
		result = getResult(nextFood[U], rounds);
		
		return result;
	}
	
	private String getResult(int numerator, int pow) {
		String result = "";
		
		int denominator = 4;	//(int) Math.pow(4, pow);
		
		result = reduce(numerator, denominator);
		System.out.println("getResult(" + numerator + ", " + denominator + ") returns " + result);
		
		return result;
	}
	
	private String reduce(int numerator, int denominator) {
		String result = "";
		
		int gcm = findGCM(numerator, denominator);

		if (gcm > 1) {
			numerator /= gcm;
			denominator /= gcm;
		}
		result = numerator + "/" + denominator;
		
		return result;
	}
	
	private int findGCM(int a, int b) {
		int gcm;
		
		if (a>b) gcm = b;
		else gcm = a;
		
		while (a%gcm==0 && b%gcm==0) {
			gcm--;
		}
		
		System.out.println("findGCM(" + a + "," + b + ") gcm=" + gcm);
		return gcm;
	}
	
	private int getFood(int round, int[] foods, int side) {
		int result;
		
		if (side<2) {
			result = foods[U] + foods[D] + foods[L] + foods[R];	// need to divide by 4 
		} else if (side < 4) {
			result = foods[F] + foods[B] + foods[L] + foods[R]; 
		} else {
			result = foods[F] + foods[B] + foods[U] + foods[D]; 
		}

		System.out.println("getFood(" + round + "," + side + ") result=" + result);
		
		return result;
	}
}
