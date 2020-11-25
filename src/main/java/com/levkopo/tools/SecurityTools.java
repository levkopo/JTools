package com.levkopo.tools;

public final class SecurityTools{

    public String generateHash(String in){
        int min = 16;

        char[] chars = in.toCharArray();
        char[] out = new char[min];

        int d = min/chars.length+1;
        for (int i = 0; i < chars.length-1; i++) {
            for (int j = 2; j < d+2; j++) {
                out[((i)*d+(j-2))] =
                        (char) ((chars[i]+(i+1<chars.length?chars[i+1]:0))/j);
            }
        }

        return new String(out);
    }
}
