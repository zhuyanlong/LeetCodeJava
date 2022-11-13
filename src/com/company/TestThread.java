package com.company;

class TestThread implements Runnable {
    private Thread t;
    private String threadName;

    TestThread(String name) {
        this.threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + this.threadName);
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + this.threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.threadName + " interrupted.");
        }
        System.out.println("Thread" + this.threadName + " exiting.");
    }

    public void startThread() {
        System.out.println("Starting " + this.threadName);
        if (t == null) {
            t =new Thread(this, threadName);
            t.start();
        }
    }
}

class TestTestThread {
    public static void main(String[] args) {
        TestThread tt1 = new TestThread("Thread-1");
        tt1.startThread();

        TestThread tt2 = new TestThread("Thread-2");
        tt2.startThread();
    }
}
