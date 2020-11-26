package com.github.levkoposc;

import java.util.HashMap;
import java.util.Map;

public final class Tools {

    /**TOOLS*/
    public static FileTools file = new FileTools();
    public static LogsTools logs = new LogsTools();
    public static SecurityTools security = new SecurityTools();
    public static ReflectionTools reflection = new ReflectionTools();

    /**PRIVATE*/
    private static final Map<String, Thread> threads = new HashMap<>();

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public Thread getThread(String name){
        return threads.get(name);
    }

    public static void runOnThread(String name, Runnable runnable){
        Thread thread = new Thread(()->{
            runnable.run();
            threads.remove(name);
        });

        threads.put(name, thread);
        thread.start();
    }
}
