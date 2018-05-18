package com.hk.main.java.tree;

public class FindMinMaxValuesinArray {

    public static void main(String[] args) {

        int[] a= new int[]{1,2,4,5,-5,60,20};
        int min = 0,max=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>=max)
                max=a[i];
            else if(a[i]<=min)
                min=a[i];
        }
        System.out.println("min:"+min+" max:"+max);
    }

}
