package com.practice.misc;

public class Threads implements Runnable{
    private Thread t;
    private Thread name;

    @Override
    public void run() {
        System.out.println("Running thread - "+ name);
    }
}
