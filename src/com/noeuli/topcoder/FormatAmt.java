package com.noeuli.topcoder;

// SRM 149 Div 2 Level 1 - 249.96pt
public class FormatAmt {
    public String amount(int dollars, int cents) {
        StringBuilder strDollar = new StringBuilder();
        
        while (dollars/1000>0) {
            int num = dollars%1000;
            dollars /= 1000;
            if (strDollar.length()>0) {
                strDollar.insert(0, ",");
            }
            strDollar.insert(0, String.format("%03d", num));
        }
        if (strDollar.length()>0) {
            strDollar.insert(0, ",");
        }
        strDollar.insert(0, dollars);

        return "$" +  strDollar + "." + String.format("%02d", cents);
    }
}
