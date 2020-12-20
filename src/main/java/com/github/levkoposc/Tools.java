package com.github.levkoposc;

import com.github.levkoposc.atomic.AtomicRun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Tools {

    /**TOOLS*/
    public static FileTools file = new FileTools();
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

    public static <T> T atomic(Supplier<T> supplier){
        AtomicReference<T> atomic = new AtomicReference<>();
        atomic.set(supplier.get());
        return atomic.get();
    }

    public static <T, V> T atomic(Supplier<V> function, AtomicRun<T, V> atomicRun){
        AtomicReference<T> atomic = new AtomicReference<>();
        atomic.set(atomicRun.get(function.get()));

        return atomic.get();
    }

    public static <T, V> T atomic(Function<Consumer<V>, ?> function, AtomicRun<T, V> atomicRun){
        AtomicReference<T> atomic = new AtomicReference<>();
        function.apply((value)->{
            atomic.set(atomicRun.get(value));
        });

        return atomic.get();
    }

    public static <T> T[] array(T... array){
        return array;
    }

    public static <T> List<T> list(T... list){
        return Arrays.asList(list);
    }

    public static Thread getThread(String name){
        return threads.get(name);
    }

    public static void runOnThread(String name, Runnable runnable){
        Thread thread = new Thread(()->{
            runnable.run();
            threads.remove(name);
        });

        threads.put(name, thread);
        thread.setName(name);
        thread.start();
    }
}
