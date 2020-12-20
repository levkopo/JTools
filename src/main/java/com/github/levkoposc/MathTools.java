package com.github.levkoposc;

public final class MathTools {

    public double average(int[] numbers){
        if (numbers.length == 0)
            return 0;

        double sum = 0;
        for (int number : numbers)
            sum += number;

        return sum / numbers.length;
    }
}
