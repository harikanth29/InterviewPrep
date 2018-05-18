

package com.hk.main.java.tree;


import java.util.ArrayList;
import java.util.List;


public class ProduceConsumeProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread(new Produce(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.start();
        t2.start();

    }
}


class Produce implements Runnable {
    List<Integer> buffer = null;
    int count = 0;

    public Produce(List<Integer> lst) {
        buffer = lst;

    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (buffer) {
                if (buffer.size() <= 5) {
                    int val = count++;
                    System.out.println("Producing buffer.." + val);
                    buffer.add(val);
                    Thread.sleep(1000);
                    buffer.notify();
                }
            }

        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            produce();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


class Consumer implements Runnable {
    List<Integer> buffer = null;
    int count = 0;

    public Consumer(List<Integer> lst) {
        buffer = lst;

    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (buffer) {
                if (buffer.size() > 0) {
                    System.out.println("Consumeing the buffer value.." + buffer.get(0));
                    buffer.remove(0);
                } else if (buffer.isEmpty()) {
                    Thread.sleep(1000);
                    buffer.notify();
                }
            }

        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

