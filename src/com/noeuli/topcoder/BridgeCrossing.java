package com.noeuli.topcoder;

import java.util.*;
import static java.lang.Math.*;

// SRM 146 Div2 Level 3 1000 point
public class BridgeCrossing {
	public int minTime(int[] times) {
		Arrays.sort(times);
		
		int N = times.length;
		int[] dp = new int[max(4, N)];
		dp[0] = times[0];
		if (N==1) return dp[0];
		dp[1] = times[1];
		if (N==2) return dp[1];
		dp[2] = times[0] + times[1] + times[2];
		if (N==3) return dp[2];
		
		for (int i=3; i<N; i++) {
			dp[i] = min( dp[i-1] + times[0] + times[i], dp[i-2] + 2*times[1] + times[i] + times[0]);
		}
		
		return dp[N-1];
	}
}
