package com.noeuli.topcoder;

import java.util.ArrayList;

// SRM 149 Div 1 Level 2 - 499.90, 
public class MessageMess {
    public String restore(String[] dictionary, String message) {
        String result = "";
        int size = dictionary.length;
        int messageLen = message.length();
        int bingo = 0;
        boolean ambiguous = false;
        ArrayList<String> resultArray = new ArrayList<String>();
        
        for (int i=0; i<size; i++) {
            String token = dictionary[i];
            int start_pos = 0;
            int foundElement = -1;
            boolean keepWhile = true;
            result = "";
            
            if (!message.startsWith(token)) {
                continue;
            }
            result += token;
            start_pos += token.length();
            if (start_pos >= messageLen) {
                bingo++;
                resultArray.add(result);
                keepWhile = false;
            } else {
                result += " ";
            }
            
            int testWhile=0;
            while (keepWhile) {
                foundElement = -1;
                
                for (int j=0; j<size; j++) {
                    String word = dictionary[j];
                    if (message.startsWith(word, start_pos)) {
                        Log.d("     [" + i + "] j=" + j + " word=" + word + " start_pos=" + start_pos + " messageLen=" + messageLen + " message=" + message);
                        foundElement = j;
                        break;
                    }
                }
                
                Log.d(" testWhile=" + testWhile++ + " foundElement=" + foundElement);
                
                if (foundElement>=0) {
                    result += dictionary[foundElement];
                    start_pos += dictionary[foundElement].length();
                    
                    Log.d(" result=[" + result + "] start_pos=" + start_pos + " messageLen=" + messageLen);
                    if (start_pos >= messageLen) {
                        bingo++;
                        resultArray.add(result);
                    } else {
                        result += " ";
                    }
                } else {
                    keepWhile = false;
                }
            }

            Log.d("i=" + i + " result=[" + result + "] bingo=" + bingo + " size=" + size);

            if (bingo>1) {
                ambiguous = true;
                break;
            }
        }
        
        if (ambiguous) return "AMBIGUOUS!";
        else if (bingo<1) return "IMPOSSIBLE!";
        return resultArray.get(0);
    }
}

/* test script
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
/ *
0) Returns: "HI YOU SAY HI"
A word from dictionary may appear multiple times in the message.
1) Returns: "AMBIGUOUS!"
"ABC BCD" and "ABCB CD" are both possible interpretations of message.
2) Returns: "IMPOSSIBLE!"
There is no way to concatenate words from this dictionary to form "IMPOSSIBLE"
3) Returns: "IMPOSSIBLE"
This message can be decoded without ambiguity. This requires the insertion of no spaces since the entire message appears as a word in the dictionary.
* /

int testCase = 3;
String[] dictionary = arrayDictionary[testCase];
String message = arrayMessage[testCase];

MessageMess testInstance = new MessageMess();
String ret = testInstance.restore(dictionary, message);
*/
