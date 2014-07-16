package com.noeuli.topcoder;

public class CeyKaps {
    public String decipher(String typed, String[] switches) {
        int[] keyboard = new int[26];
        for (int i=0; i<26; i++) keyboard[i] = 'A' + i;
        
        int count = switches.length;
        for (int i=0; i<count; i++) {
            int a=0, b=0;
            a = switches[i].charAt(0) - 'A';
            b = switches[i].charAt(2) - 'A';
            
            int save = keyboard[a];
            keyboard[a] = keyboard[b];
            keyboard[b] = save;
        }
        
        String msg = "";
        for(int i=0; i<typed.length(); i++) {
            int newIndex = findIndex(keyboard, typed.charAt(i));
            if (newIndex<0) {
                return null;
            }
            msg += String.valueOf((char)('A' + newIndex));
        }
        
        
        return msg;
    }
    
    private int findIndex(int[] keyboard, char value) {
        for(int i=0; i<keyboard.length; i++) {
            if (keyboard[i] == value) return i;
        }
        return -1;
    }
}

/* test script
String[] arrayTyped = {
"AAAAA",
"ABCDE",
"IHWSIOTCHEDMYKEYCAPSARWUND",

};
String[][] arraySwitches = {
{"A:B","B:C","A:D"},
{"A:B","B:C","C:D","D:E","E:A"},
{"W:O","W:I"},

};
/ *
0) Returns: "CCCCC"
At first, all keys look right. 
After the A:B switch, A looks like B and B looks like A. 
After the B:C switch, A looks like C, B looks like A, and C looks like B. 
The third switch is irrelevant. 
Since "AAAAA" is what comes out, Timmy must have been pressing "CCCCC".

1) Returns: "AEBCD"
2) Returns: "WHOSWITCHEDMYKEYCAPSAROUND"
* /

int testCase = 4;
String typed = arrayTyped[testCase];
String[] switches = arraySwitches[testCase];

CeyKaps testInstance = new CeyKaps();
String ret = testInstance.decipher(typed, switches);
*/
