package com.github.levkoposc;
import java.io.PrintStream;
import java.io.StringWriter;

import static com.github.levkoposc.Tools.*;

public final class LogsTools {

    private String path = null;

    public void err(Object object, String message){
        System.err.println(object.getClass().getSimpleName()+": error: "+message);
        if(path!=null)
            file.addToFile(path, object.getClass().getSimpleName()+": error: "+message+"\n\r");
    }

    public void v(Object object, String message){
        System.out.println(object.getClass().getSimpleName()+": v: "+message);

        if(path!=null)
            file.addToFile(path, object.getClass().getSimpleName()+": v: "+message+"\n\r");
    }

    public void setLogsPath(String path) {
        this.path = path;
    }
}
