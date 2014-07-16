package com.noeuli.topcoder;

public class Log {
    public static final void d(String tag, String msg) {
        System.out.println(tag + "\t" + msg);
    }
    
    public static final void d(String msg) {
        System.out.println(msg);
    }
    
    public static final void e(String tag, String msg) {
        d(tag, msg);
    }
    
    public static final void e(String msg) {
        d(msg);
    }
    
    public static final void endl() {
        System.out.println();
    }
}
