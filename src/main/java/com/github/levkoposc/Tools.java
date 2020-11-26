package com.github.levkoposc;

import java.util.HashMap;
import java.util.Map;

public final class Tools {
    public static FileTools file = new FileTools();
    public static LogsTools logs = new LogsTools();
    public static SecurityTools security = new SecurityTools();

    public static Map<Integer, Thread> threads = new HashMap<>();

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void runOnThread(Runnable runnable){
        int threadId = threads.size()+1;
        Thread thread = new Thread(()->{
            runnable.run();
            threads.remove(threadId);
        });

        threads.put(threadId, thread);
        thread.start();
    }
}
