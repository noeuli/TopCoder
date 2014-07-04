package com.noeuli.topcoder;

import java.util.Arrays;

// SRM 147 Div 2 Level 3 Point 950
public class GoldenChain {
	/**
	 * I remember a chain problem from my childhood. Suppose you have four 
	 * sections of a golden chain. Each consists of three links joined together 
	 * in a line. You would like to connect all four sections into a necklace. 
	 * The obvious solution is to cut the last link of each section and use it 
	 * to connect the first section to the second one, then the second to the 
	 * third, then the third to the fourth, then the fourth to the first one. 
	 * If you want to minimize the number of cuts, you can do better. You can cut
	 * one of the three link sections into its individual links. Using the three 
	 * loose links you can join the three remaining sections together.
	 * 
	 * Your task is, given the lengths of the sections, to return the minimum 
	 * number of cuts to make one big circular necklace out of all of them.
	 * 
	 * each element of sections is between 1 and 2,147,483,647 inclusive
	 * the sum of all elements of sections is between 3 and 2,147,483,647 inclusive
	 * 
	 * @param sections has between 1 and 50 elements inclusive.
	 * @return the minimum number of cuts to make one big circular necklace out of all of them.
	 */
	public int minCuts(int[] sections) {
		int result = 0;
		
		if (sections.length==1) return 1;
		
		// sort input sections
		Arrays.sort(sections);
		
		for (int i=0; i<sections.length; i++) {
			int linksNeeded = sections.length-i;
			int sum = getSum(sections, 0, i);
			
			if (linksNeeded-1 == sum) {
				System.out.println("case 1 linksNeeded=" + linksNeeded + " i=" + i + " sum=" + sum);
				result = sum;
				break;
			} else if (linksNeeded <= sum) {
				System.out.println("case 2 linksNeeded=" + linksNeeded + " i=" + i + " sum=" + sum);
				result = linksNeeded;
				break;
			}
		}

		return result;
	}
	
	public int getSum(int[] array, int start, int end) {
		int sum = 0;
		
		for (int i=start; i<=end; i++) {
			sum += array[i];
		}
		
		return sum;
	}
}
