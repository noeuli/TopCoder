package com.noeuli.topcoder;

public class CCipher {
	public String decode(String cipherText, int shift) {
		String result = "";
		
		for (int i=0; i<cipherText.length(); i++) {
			char ch = cipherText.charAt(i);
			if (ch-shift < 'A') ch += 26; 
			ch -= shift;
			result += String.valueOf(ch);
		}
		return result;
	}

}
