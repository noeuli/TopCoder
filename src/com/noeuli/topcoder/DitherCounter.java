package com.noeuli.topcoder;

public class DitherCounter {
	public int count(String dithered, String[] screen) {
		int result = 0;
		for (int i=0; i<screen.length; i++) {
			String line = screen[i];
			for (int j=0; j<dithered.length(); j++) {
				String color = dithered.substring(j, j+1);
				for (int k=0; k<line.length(); k++) {
					if (line.substring(k, k+1).equals(color)) result++;
				}
			}
		}
		return result;
	}

}
