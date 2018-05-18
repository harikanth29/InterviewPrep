

package com.hk.main.java.tree;


import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {
    public static Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public class Node {
        int data;
        Node lNode;
        Node rNode;

        public Node(int value, Node node) {
            this.data = value;
            this.lNode = node;
            this.rNode = node;
        }

        public void insert(int value) {
            Node node;
            Node parent, current;

            if (root == null) {
                node = new Node(value, null);
                root = node;
                return;
            } else {
                current = this;
                parent = current;
                if (value > current.data) {
                    current = current.rNode;
                    if (current == null) {
                        current = new Node(value, null);
                        parent.rNode = current;
                        return;
                    } else {
                        current.insert(value);
                    }

                } else {
                    current = current.lNode;
                    if (current == null) {
                        current = new Node(value, null);
                        parent.lNode = current;
                        return;
                    } else {
                        current.insert(value);
                        ;
                    }
                }

            }
        }
    }

    public void insert(int value) {
        if (root != null) {
            root.insert(value);
        } else {
            root = new Node(value, null);
        }

    }

    public void dfsInOrder(Node root) {

        if (root != null) {
            dfsInOrder(root.lNode);
            System.out.print(root.data + "->");
            dfsInOrder(root.rNode);
        } else {
            return;
        }

    }

    public void bfs(Node root) {
        if (root != null) {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node current = q.poll();
                if (current == null) {
                    if (q.isEmpty())
                        return;
                    q.add(null);
                    System.out.println();
                } else {
                    System.out.print(current.data + "->");
                    if (current.lNode != null)
                        q.add(current.lNode);
                    if (current.rNode != null)
                        q.add(current.rNode);
                }
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(30);
        bst.insert(15);
//        bst.insert(18);
        bst.insert(100);
        bst.insert(5);
        bst.insert(1);
        bst.insert(9);
        bst.insert(20);
        bst.insert(99);
        bst.insert(8);
        bst.insert(25);
        System.out.println("DFS***");
         bst.dfsInOrder(root);
         System.out.println();
        System.out.println("BFS***");
        bst.bfs(root);
    }
}
