package com.github.levkoposc;

public final class MathTools {

    public double average(int[] integers){
        int sum = 0;
        for(int integer: integers)
            sum += integer;

        return (double) sum/integers.length;
    }
}
