

package com.hk.main.java.tree;


import java.util.ArrayList;
import java.util.List;


public class Stack {
    int[] arr = null;
    int index = 0;
    int capacity = 0;

    public Stack(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    public static void main(String[] args) {

        Stack st = new Stack(30);
        st.push(1);
        st.push(12);
        st.push(14);
        st.push(16);
        st.push(18);
        st.push(20);
        st.push(30);
        st.push(50);
        st.printStatc();
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.printStatc();
    }

    public void printStatc() {
        System.out.println("Stack Elements are ..");
        for (int a = 0; a < index; a++) {
            System.out.print(arr[a] + "->");
        }
    }

    public int pop() {
        if (arr.length > 0) {
            return arr[--index];

        } else {
            return -1;
        }

    }

    public void push(int a) {

        if (index == capacity)
            System.out.println("Heap is full..");
        arr[index] = a;
        index++;

    }

}
