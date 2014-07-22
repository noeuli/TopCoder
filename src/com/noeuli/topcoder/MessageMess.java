package com.noeuli.topcoder;

import java.util.ArrayList;

public class MessageMess {
    private static final String TAG = "MessageMess";
    private static final boolean LOGD = true;
    
    String mResult = "";
    
    public String restore1(String[] dictionary, String message) {
        int size = dictionary.length;
        int bingo = 0;
        boolean ambiguous = false;
        ArrayList<String> resultArray = new ArrayList<String>();
        
        
        
        
        
        for (int i=0; i<size; i++) {
            if (insertSpace(i, dictionary, message)) {
                bingo++;
                resultArray.add(mResult);
            }
            if (bingo>1) {
                ambiguous = true;
                break;
            }
            mResult = "";
        }
        
        if (ambiguous) return "AMBIGUOUS!";
        else if (bingo<1) return "IMPOSSIBLE!";
        
        return resultArray.get(0);
    }
    
    private boolean insertSpace(int start, String[] dictionary, String message) {
        boolean made = false;
        int nextPos = 0;
        String token = dictionary[start];

        if (message.startsWith(token, nextPos)) {
            int messageLen = message.length();
            int tokenLen = token.length();
            if (tokenLen + nextPos == messageLen) {
                // completed
                mResult += token;
                return true;
            } else if (tokenLen + nextPos > messageLen) {
                // failed
                mResult = "";
                return false;
            } else {
                // continue
                mResult += token + " ";
                nextPos += tokenLen;

                boolean stop = true;
                while (!stop || tokenLen+nextPos >= messageLen) {
                    for (int i=0; i<dictionary.length; i++) {
                        token = dictionary[i];
    
                        if (message.startsWith(token, nextPos)) {
                            stop = false;
                            messageLen = message.length();
                            tokenLen = token.length();
    
                            if (tokenLen + nextPos == messageLen) {
                                // completed
                                mResult += token;
                                made = true;
                                break;
                            } else if (tokenLen + nextPos > messageLen) {
                                // failed
                                mResult = "";
                                break;
                            } else {
                                // continue
                                mResult += token + " ";
                                nextPos += tokenLen;
                            }
                        }
                    }
                }
                
                
            }
        }
        
        return made;
    }
    
    // test
    public String restore(String[] dictionary, String message) {
        int size = dictionary.length;
        int bingo = 0;
        boolean ambiguous = false;

        boolean someCondition = true;
        NEXT_POS = 0;

        while (someCondition) {
            if (findWord(dictionary, message)) {
                bingo++;
            }
            if (bingo>1) {
                ambiguous = true;
                break;
            }
            someCondition = false;
        }
        
        if (ambiguous) return "AMBIGUOUS!";
        else if (bingo<1) return "IMPOSSIBLE!";
        return RESULT;
    }
    
    
    String RESULT = "";
    int NEXT_POS = 0;
    
    public boolean findWord(String[] dictionary, String message) {
        boolean bingo = false;
        
        for (int i=0; i<dictionary.length; i++) {
            if (message.startsWith(dictionary[i], NEXT_POS)) {
                RESULT += dictionary[i];
                NEXT_POS += dictionary[i].length();
                bingo = true;
                break;
            }
        }
        
        return bingo;
    }
    /*
    private boolean sub(String token, int nextPos, String message) {
        boolean completed = false;
        if (message.startsWith(token, nextPos)) {
            int messageLen = message.length();
            int tokenLen = token.length();

            if (tokenLen + nextPos == messageLen) {
                // completed
                mResult += token;
                completed = true;
            } else if (tokenLen + nextPos > messageLen) {
                // failed
                mResult = "";
            } else {
                // continue
                mResult += token + " ";
                nextPos += tokenLen;
            }
        }
        return completed;
    }
    */
}
