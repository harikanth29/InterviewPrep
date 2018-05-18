

package com.hk.main.java.tree;


public class Palindrome {
    public static void main(String[] args) {
        String ip = "Sator Arepo Tenet Opera Rotas";
        Palindrome pp = new Palindrome();
        System.out.println("String is " + pp.isPolindrome(ip));

    }

    public static boolean isPolindrome(String ip) {
        boolean polindrome = true;
        char[] sArr = ip.toLowerCase().toCharArray();
        int n = ip.length();
        for (int i = 0; i <= n - 1; i++) {
            if (i != (n - 1) - i) {
                if (!(sArr[i] == sArr[(n - 1) - i])) {
                    polindrome = false;
                    return polindrome;
                }
            }
        }
        return polindrome;
    }
}
