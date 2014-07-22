package com.noeuli.topcoder;

public class TopCoder {
	public static void main(String[] args) {
	    String[][] arrayDictionary = {
	            {"HI", "YOU", "SAY"},
	            {"ABC", "BCD", "CD", "ABCB"},
	            {"IMPOSS", "SIBLE", "S"},
	            {"IMPOSS", "SIBLE", "S", "IMPOSSIBLE"},
        };
	    String[] arrayMessage = {
	            "HIYOUSAYHI",
	            "ABCBCD",
	            "IMPOSSIBLE",
	            "IMPOSSIBLE",
	    };
        /*
        0) Returns: "HI YOU SAY HI"
        A word from dictionary may appear multiple times in the message.
        1) Returns: "AMBIGUOUS!"
        "ABC BCD" and "ABCB CD" are both possible interpretations of message.
        2) Returns: "IMPOSSIBLE!"
        There is no way to concatenate words from this dictionary to form "IMPOSSIBLE"
        3) Returns: "IMPOSSIBLE"
        This message can be decoded without ambiguity. This requires the insertion of no spaces since the entire message appears as a word in the dictionary.
	    */

        int testCase = 0;
        String[] dictionary = arrayDictionary[testCase];
        String message = arrayMessage[testCase];

        MessageMess testInstance = new MessageMess();
        String ret = testInstance.restore(dictionary, message);
		
		System.out.println(ret);
	}
}