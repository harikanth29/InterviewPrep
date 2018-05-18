

package com.hk.main.java.tree;


public class Heap {

    int[] heap = null;
    int size = 0;
    int capacity = 0;

    public Heap(int capacity) {
        heap = new int[capacity];
        this.capacity = capacity;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return (2 * index + 1) ;
    }

    public int getRightChildIndex(int index) {
        return (2 * index + 2) ;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) < size;
    }

    public void insert(int k) {
        if (size == capacity)
            System.out.println("Heap is full..");
        heap[size] = k;
        size++;
        heapifyUp();


    }

    public int delete() {
        int item = heap[0];
        heapifyDown();
        size--;
        return item;
    }

    public void heapifyDown() {
        int current = 0;
        heap[0] = heap[size - 1];
        while (hasLeftChild(current)) {
            int smallIndex = getLeftChildIndex(current);
            if (hasRightChild(current) && heap[getRightChildIndex(current)] < heap[smallIndex]) {
                smallIndex = getRightChildIndex(current);
            }
            if (heap[current] < heap[smallIndex]) {
                break;
            } else {
                swap(current, smallIndex);
            }
            current = smallIndex;
        }

    }

    public void heapifyUp() {
        int current = size - 1;
        while (hasParent(current) && heap[getParentIndex(current)] > heap[current]) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
    }

    public void swap(int to, int from) {
        int temp = heap[to];
        heap[to] = heap[from];
        heap[from] = temp;
    }

    public void printHeap() {
        System.out.println("Heap is ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + "->");
        }
    }

    public static void main(String[] args) {
        Heap hh = new Heap(39);
        hh.insert(1);
        hh.insert(9);
        hh.insert(11);
        hh.insert(27);
        hh.insert(44);
        hh.insert(14);
        hh.insert(30);
        hh.insert(55);
        hh.printHeap();
         System.out.print(hh.delete());

        hh.printHeap();

    }

}
