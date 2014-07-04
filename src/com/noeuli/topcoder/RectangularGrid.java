package com.noeuli.topcoder;

// SRM 146 DIV2 Level 2 500 point
public class RectangularGrid {
	public long countRectangles(int width, int height) {
		long result = 0;
		
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				if (x!=y) {
					result += (width-x)*(height-y);
				}
			}
		}
		return result;
	}
}
