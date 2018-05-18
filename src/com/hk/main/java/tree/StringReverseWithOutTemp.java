

package com.hk.main.java.tree;


public class StringReverseWithOutTemp {

    public static void main1(String[] args) {

        String str = "stanford university";
        char[] chr = str.toCharArray();
        int size = chr.length;
        char[] op = new char[size];
        for (int i = 0; i < size; i++) {
            op[i] = chr[(size-1) - i];
        }
        System.out.println("Original str:" + str);
        System.out.println("Reverse str:" + new String(op));
    }
    public static void main(String[] args) {
        String reverseMe = "reverse me!";
        for (int i = 0; i < reverseMe.length(); i++) {
            reverseMe = reverseMe.substring(1, reverseMe.length() - i)
                + reverseMe.substring(0, 1)
                + reverseMe.substring(reverseMe.length() - i, reverseMe.length());
         }
         System.out.println(reverseMe);
         System.out.println(Integer.toBinaryString(-12));
         System.out.println(Integer.toBinaryString(12));
    }

}
