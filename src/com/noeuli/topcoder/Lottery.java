package com.noeuli.topcoder;

import java.util.Arrays;

public class Lottery {
	class LotteryInfo implements Comparable<LotteryInfo> {
		String name;
		int choices;	// 10~100
		int blanks;		// 1~8
		boolean sorted;
		boolean unique;
		long base;
		
		public LotteryInfo(String rule) {
			String[] dirty = rule.split(":");
			name = dirty[0];
			
			String[] elements = dirty[1].substring(1).split(" ");

			choices = Integer.valueOf(elements[0]);
			blanks = Integer.valueOf(elements[1]);
			sorted = (elements[2].equals("T") ? true : false);
			unique = (elements[3].equals("T") ? true : false);
			base = getBase();
		}
		
		public long getBase() {
			long result = 0;
			if (!sorted) {
				if (!unique) {
					// easiest part.
					result = (long) Math.pow(choices,  blanks);
				} else {
					// only unique.
					result = (long) (getCombination(choices, blanks)*factorial(blanks));
				}
			} else {
				if (!unique) {
					// the tricky part. only sorted and not unique.
					result = getRepeatCombination(choices, blanks);
				} else {
					// sorted and unique.
					result = getCombination(choices, blanks);
				}
			}

			return result;
		}
		
		public long getRepeatCombination(int n, int r) {
			return getCombination(n+r-1, r);
		}

		public long getCombination(int n, int r) {
			long res = 1;
			for(int i=n; i>(n-r); i--) {
				res *= i;
			}
			return res/factorial(r);
		}

		// used only for blank!
		public long factorial(int n) {
			return (n<2 ? 1 : n * factorial(n-1));
		}
		
		public String toString() {
			return name + ": " + choices + " " + blanks
					+ " " + sorted + " " + unique + " :" + base;
		}

		@Override
        public int compareTo(LotteryInfo info) {
			int ret = 0;
			
			if (base > info.base) {
				ret = 1;
			} else if (base < info.base) {
				ret = -1;
			} else {
				ret = name.compareTo(info.name);
			}
	        return ret;
        }
	}

	public String[] sortByOdds(String[] rules) {
		String[] result = new String[rules.length];
		LotteryInfo[] infos = new LotteryInfo[rules.length];

		for (int i=0; i<rules.length; i++) {
			infos[i] = new LotteryInfo(rules[i]);
			System.out.println("List info[" + i + "] " + infos[i]);
		}
		
		System.out.println("");
		
		Arrays.sort(infos);
		
		for (int i=0; i<infos.length; i++) {
			// test result
			System.out.println("Sorted info[" + i + "] " + infos[i]);
			result[i] = infos[i].name;
		}
		

		return result;
	}
}