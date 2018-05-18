

package com.hk.main.java.tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 60, 30, -50, -70, -7, 7, -38, -8, 150 };
        boolean allPositive = true;
        boolean allNegative = true;
        int sum = 0;
        int ans = 0;
        int negativeSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int s =0;
        List<String> lst = new ArrayList<>();
        lst.
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > 0)
                allNegative = false;
            if (arr[i] < 0)
                allPositive = false;
        }
        if (allPositive) {
            for (int i = 0; i <= arr.length - 1; i++) {
                sum += arr[i];
                end = i;
            }
        }
        if (allNegative) {
            for (int i = 0; i <= arr.length - 1; i++) {
                if (arr[i] > negativeSum) {
                    negativeSum = arr[i];
                    start = i;
                    end = i;
                }
            }
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            sum += arr[i];
            if (ans < sum) {
                ans = sum;
                start=s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }
        System.out.println("Actual arr is ");
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("sum is :" + ans);
        System.out.println("Sub arr is ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
