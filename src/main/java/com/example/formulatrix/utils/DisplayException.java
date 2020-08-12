package com.example.formulatrix.utils;

import java.io.StringWriter;
import java.io.PrintWriter;

public class DisplayException {
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}