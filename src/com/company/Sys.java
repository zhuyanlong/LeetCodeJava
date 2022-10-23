package com.company;

public class Sys extends Thread {
    boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        Sys thread = new Sys();
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping apllication...");
    }
    public void run() {
        while(!stop) {
            System.out.println("Thread is running...");
        }
        System.out.println("Thread exiting under request...");
    }
}
