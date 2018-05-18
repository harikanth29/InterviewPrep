

package com.hk.main.java.tree;


import java.util.HashMap;


public class HashMapImpl {

    public static Node[] array = new Node[50];

    public HashMapImpl() {

    }

    public int hashCode(int key) {
        return key + 1;
    }

    public class Node {

        String data;
        int key;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        int hashcode;
        Node next;

        public Node() {

        }

        public Node(String data, int key, int hashcode, Node next) {
            super();
            this.data = data;
            this.key = key;
            this.hashcode = hashcode;
            if (next != null)
                next.next = this;
        }

        public boolean equals(int key) {
            if (this.key == key)
                return true;
            else
                return false;

        }

    }

    public void put(int key, String value) {
        put(key, hashCode(key), value);

    }

    public void put(int key, int hashCode, String value) {
        if (array[hashCode] != null) {
            Node node = new Node(value, key, hashCode, null);
            array[hashCode] = node;
        } else {
            Node currentNode = array[hashCode];
            Node node = new Node(value, key, hashCode, currentNode);
        }

    }

    public Node get(int key) {
        return get(key, hashCode(key));
    }

    public Node get(int key, int hashCode) {
        Node node = null;
        if (array[hashCode] != null) {
            Node obj = array[hashCode];
            if (obj.equals(key))
                node = obj;
            else {
                node = getNext(key, obj.next);
            }
        }
        return node;
    }

    public Node getNext(int key, Node node) {
        Node nexNode = node;
        while (nexNode != null) {
            if (nexNode.equals(key))
                return nexNode;
            else
                nexNode = nexNode.next;
        }
        return nexNode;
    }

    public static void main(String[] args) {
        HashMapImpl map = new HashMapImpl();
        // map.put(null, null);
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");
        map.put(1, "test1");
        Node node = map.get(1);
        System.out.print("key:" + node.getKey());
        System.out.print(" Val:" + node.getData());
        System.out.println();
    }
}
