package com.hk.main.java.tree;

import java.util.*;

public class CombinationsOfPhoneNo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList<String> ss= CombinationsOfPhoneNo.letterCombinations("23");
        for(String s:ss){
            System.out.print(s+",");
        }
    }
    
    public static LinkedList<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

}
