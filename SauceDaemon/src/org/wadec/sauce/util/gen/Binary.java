package org.wadec.sauce.util.gen;

/**
 *
 * @author Wade C
 */
public class Binary {

    public static int defaultBitLen = 8;

    public static String toBinary(String text) {
        return toBinary(defaultBitLen, text);
    }

    public static String toBinary(int bitlen, String text) {
        char[] car = text.toCharArray();
        String r = null;
        for (char c : car) {
            r = r == null ? toBinary(bitlen, c) : r + toBinary(bitlen, c);
        }
        return r;
    }

    public static String toBinary(int bitlen, char car) {
        int c = car, total = 0;
        int[] x = bits(bitlen);
        String r = null;
        for (int i : x) {
            if ((total + i) > c) {
                r = r == null ? "0" : r + "0";
                continue;
            }
            total += i;
            r = r == null ? "1" : r + "1";
        }
        return r;
    }

    private static int[] bits(int bitlen) {
        int[] x = new int[bitlen];
        String r = null;
        for (int i = 0; i < bitlen; i++) {
            x[bitlen - 1 - i] = (int) Math.pow(2, i);
        }
        return x;
    }
}