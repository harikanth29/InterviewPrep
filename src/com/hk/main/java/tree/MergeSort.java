

package com.hk.main.java.tree;


public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 1, 2, 4, 6, 20, 22, 4, 6, 9, 10, 40 };
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("Original Array is ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("SortedArray is ");
        for (int i = 0; i < temp.length - 1; i++) {
            System.out.print(temp[i] + ",");
        }
    }

    public static void mergeSort(int[] arr, int[] temp, int s, int e) {
        if (s >= e) {
            return;
        }
        int m = (e + s) / 2;
        mergeSort(arr, temp, s, m);
        mergeSort(arr, temp, m + 1, e);
        merge(arr, temp, s, e);
    }

    public static void merge(int[] arr, int[] temp, int start, int end) {
        int middle = start + end / 2;
        int index = start;
        int leftEnd = middle;
        int size =   end-start+1;
        int rightStart = middle + 1;
        while (start <= leftEnd && rightStart <= end) {
            if (arr[start] <= arr[rightStart]) {
                temp[index] = arr[start];
                start++;
            } else {
                temp[index] = arr[rightStart];
                rightStart++;
            }
            index++;
        }
        while (start <= leftEnd && index <= size) {
            temp[index] = arr[start];
            start++;
            index++;
        }
        while (rightStart <= end && index <= size) {
            temp[index] = arr[rightStart];
            rightStart++;
            index++;
        }

    }
}
