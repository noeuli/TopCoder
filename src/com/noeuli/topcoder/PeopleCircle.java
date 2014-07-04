package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 147 Div 2 Level 2 Point 600
// SRM 147 Div 1 Level 1 Point 350
public class PeopleCircle {
	/**
	 * @param numMales is between 0 and 25 inclusive
	 * @param numFemales is between 0 and 25 inclusive
	 * @param K is between 1 and 1000 inclusive
	 * @return original order in string.
	 */
	public String order(int numMales, int numFemales, int K) {
		String result = "";
		
		if (numMales==0 && numFemales==0) return "";
		
		if (numMales==0) {
			for (int i=0; i<numFemales; i++) {
				result += "F";
			}
		}
		
		if (numFemales==0) {
			for (int i=0; i<numMales; i++) {
				result += "M";
			}
		}
		
		if (result.length()>0) return result;
		
		// Initialize Men list
		ArrayList<String> array = new ArrayList<String>();
		for (int i=0; i<numMales; i++) {
			array.add("M");
		}
		
		// Assume that the last position is start.
		// Add females in reverse order
		int pos = array.size() - 1;
		for (int i=0; i<numFemales; i++) {
			array.add(pos, "F");

			int MOD = K % array.size();
			if (MOD>0) MOD--;
			else MOD = array.size()-1;

			pos -= MOD;
			if (pos<0){
				pos += array.size();
			}
		}

		for (int i=pos; i<array.size(); i++) {
			result += array.get(i);
		}
		for (int i=0; i<pos; i++) {
			result += array.get(i);
		}
		
		return result;
	}
}